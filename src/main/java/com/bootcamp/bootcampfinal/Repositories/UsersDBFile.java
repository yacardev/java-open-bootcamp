package com.bootcamp.bootcampfinal.Repositories;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import com.bootcamp.bootcampfinal.Entities.User;

public class UsersDBFile extends UsersDB {
 
        public String dataFile = "users.txt";

        @Override
        public ArrayList<User> getUser() {
            ArrayList<User> users = new ArrayList();

            try {
                Scanner scanner = new Scanner(new File(dataFile));

                while (scanner.hasNext()) {
                    String actualUser = scanner.next();
                    String []partes = actualUser.split(",");

                    User user = new User();
                    user.nickName = partes[0];
                    user.name = partes[1];
                    user.lastName = partes[2];
                    user.email = partes[3];
                    user.profile = Integer.parseInt(partes[4]);

                    users.add(user);
                }

                scanner.close();
            } catch (Exception e) {
            }

            return users;
        }

        @Override
        public User searchUser(User user) {
            ArrayList<User> users = getUser();

            for (User actualUser : users) {
                if (actualUser.nickName.equalsIgnoreCase(user.nickName)) {
                    return actualUser;
                }
            }

            return null;
        }

        @Override
        public void create(User user) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(dataFile, true);
                PrintStream printStream = new PrintStream(fileOutputStream);
                printStream.println(separateByCommas(user));
                printStream.flush();
                printStream.close();
            } catch (Exception e) {
            }

            increaseAddeed();
        }

        @Override
        public void delete(User user) {
            ArrayList<User> users = getUser();

            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).nickName.equalsIgnoreCase(user.nickName)) {
                    users.remove(i);
                }
            }

            try {
                PrintStream printStream = new PrintStream(dataFile);

                for (User actualUser : users) {
                    String userComas = separateByCommas(actualUser);
                    printStream.println(userComas);
                }

                printStream.close();
            } catch (Exception e) {
            }

            increaseDeleted();
        }

        private String separateByCommas(User user) {
            return user.nickName + ","
                    + user.name + ","
                    + user.lastName+ ","
                    + user.email + ","
                    + user.profile;
        }
        


}
