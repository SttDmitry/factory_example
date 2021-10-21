package com.example.demo.cinema;

import com.example.demo.cinema.entity.Film;
import com.example.demo.cinema.entity.Order;
import com.example.demo.cinema.entity.Session;
import com.example.demo.cinema.entity.SessionFiltered;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static List<Film> films = new ArrayList<>();

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        List<Session> sessions = new ArrayList<>();
        List<SessionFiltered> sessionsFiltered = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema?" +
                    "user=geek&password=geek");
            stmt = conn.createStatement();
            if (stmt.execute("SELECT * FROM films")) {
                rs = stmt.getResultSet();
                while (rs.next()) {
                    Film temp = new Film(Integer.valueOf(rs.getString(1)), rs.getString(2));
                    films.add(temp);
                }
            }
            Collections.sort(films);

            if (stmt.execute("SELECT * FROM sessions")) {
                rs = stmt.getResultSet();
                while (rs.next()) {
                    Session temp = new Session(Integer.valueOf(rs.getString(1)), Integer.valueOf(rs.getString(2)),
                            rs.getObject(3, LocalDateTime.class), rs.getObject(4, LocalDateTime.class), Integer.valueOf(rs.getString(5)));
                    sessions.add(temp);
                }
            }
            Collections.sort(sessions);

            if (stmt.execute("SELECT * FROM orders")) {
                rs = stmt.getResultSet();
                while (rs.next()) {
                    Order temp = new Order(Integer.valueOf(rs.getString(1)), Integer.valueOf(rs.getString(2)), Integer.valueOf(rs.getString(3)));
                    orders.add(temp);
                }
            }
            Collections.sort(orders);

            //1.
            System.out.println("Firts task:");
            for (int i = 1; i < sessions.size(); i++) {
                if (sessions.get(i - 1).getSessionEnd().isAfter(sessions.get(i).getSessionStart())) {
                    System.out.println(filmName(sessions.get(i - 1)) + ", " + sessions.get(i - 1).getSessionStart() + ", " + timePeriod(sessions.get(i - 1)) + ", " + filmName(sessions.get(i)) + ", " + sessions.get(i).getSessionStart() + ", " + timePeriod(sessions.get(i)));
                }
            }

            //2
            System.out.println("\nSecond task:");
            for (int i = 1; i < sessions.size(); i++) {
                if (minutesBetween(timePeriod(sessions.get(i - 1), sessions.get(i))) >= 30) {
                    sessionsFiltered.add(new SessionFiltered(filmName(sessions.get(i - 1)), sessions.get(i - 1).getSessionStart(), timePeriod(sessions.get(i - 1)), sessions.get(i).getSessionStart(), timePeriod(sessions.get(i - 1), sessions.get(i)), minutesBetween(timePeriod(sessions.get(i - 1), sessions.get(i)))));
                }
            }
            Collections.sort(sessionsFiltered);
            for (int i = sessionsFiltered.size() - 1; i >= 0; i--) {
                System.out.println(sessionsFiltered.get(i));
            }

            //3
            System.out.println("\nThird task:");
            Map<Integer, Integer> sessionsWithPrice = new HashMap<>();
            int count;
            for (int j = 0; j < sessions.size(); j++) {
                count = 0;
                for (int k = 0; k < orders.size(); k++) {
                    if (orders.get(k).getSessionId().equals(sessions.get(j).getId())) {
                        count++;
                    }
                }
                sessionsWithPrice.put(j, count);
            }

            int priceSum;
            int priceAll = 0;
            int countViewers;
            int countViewersAll = 0;
            int countSessions;
            int countSessionsAll = 0;
            for (int i = 0; i < films.size(); i++) {
                priceSum = 0;
                countViewers = 0;
                countSessions = 0;
                for (int j = 0; j < sessions.size(); j++) {
                    if (sessions.get(j).getFilmId().equals(films.get(i).getId())) {
                        countSessions++;
                        countViewers+=sessionsWithPrice.get(j);
                        priceSum+=sessions.get(j).getPrice()*sessionsWithPrice.get(j);
                    }
                }
                priceAll+=priceSum;
                countViewersAll+=countViewers;
                countSessionsAll+=countSessions;
                System.out.println(films.get(i).getName() + ", viewers:" + countViewers + ", avg:" + countViewers/countSessions*1f + ", priceSum:" + priceSum);
            }
            System.out.println("Total viewers: " + countViewersAll + ", avg:" + countViewersAll/countSessionsAll*1f + ", priceSum:" + priceAll);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                }

                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                }

                stmt = null;
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    public static String filmName(Session s) {
        return films.get(s.getFilmId() - 1).getName();
    }

    public static String timePeriod(Session s) {
        int hours = s.getSessionEnd().getHour() - s.getSessionStart().getHour();
        int minutes = s.getSessionEnd().getMinute() - s.getSessionStart().getMinute();
        if (minutes < 0) {
            hours--;
            minutes = 60 + minutes;
        }
        return hours + " hour(s) " + minutes + " minutes";
    }

    public static String timePeriod(Session first, Session second) {
        int hours = second.getSessionStart().getHour() - first.getSessionEnd().getHour();
        int minutes = second.getSessionStart().getMinute() - first.getSessionEnd().getMinute();
        if (minutes < 0) {
            hours--;
            minutes = 60 + minutes;
        }
        return hours + " hour(s) " + minutes + " minutes";
    }

    public static int minutesBetween(String s) {
        String[] parts = new String[4];
        parts = s.split(" ");
        return Integer.parseInt(Integer.parseInt(parts[0]) * 60 + parts[2]);
    }
}
