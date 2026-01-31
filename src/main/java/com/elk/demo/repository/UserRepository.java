package com.elk.demo.repository;

import com.elk.demo.model.Organisation;
import com.elk.demo.model.User;
import com.elk.demo.model.UserRequestDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.ArrayList;

@Component
public class UserRepository {

    private final List<User> users = new ArrayList<>(List.of(
            new User(1, "Mohamed El Youssoufi", "mohamed.elyoussoufi@example.com", "pass123", Organisation.FINANCE),
            new User(2, "Youssef Boulahlib", "youssef.boulahlib@example.com", "pass123", Organisation.IT),
            new User(3, "Omar El Amrani", "omar.elamrani@example.com", "pass123", Organisation.SALES),
            new User(4, "Ahmed Naciri", "ahmed.naciri@example.com", "pass123", Organisation.IT),
            new User(5, "Rachid El Idrissi", "rachid.elidrissi@example.com", "pass123", Organisation.CUSTOMER_SERVICE),
            new User(6, "Samira Bennani", "samira.bennani@example.com", "pass123", Organisation.MARKETING),
            new User(7, "Fatima Zahra El Khatib", "fatima.zahra.khatib@example.com", "pass123", Organisation.HR),
            new User(8, "Khadija Chraibi", "khadija.chraibi@example.com", "pass123", Organisation.HR),
            new User(9, "Soufiane Amghar", "soufiane.amghar@example.com", "pass123", Organisation.OPERATIONS),
            new User(10, "Hassan El Maati", "hassan.elmaati@example.com", "pass123", Organisation.HR),
            new User(11, "Ziad El Kalali", "hassan.elmaati@example.com", "pass123", Organisation.HR),
            new User(12, "Lina El Kalali", "hassan.elmaati@example.com", "pass123", Organisation.HR)
    ));

    public List<User> findAll() {
        return this.users;
    }

    public long count() {
        return this.users.size();
    }

    public User patchUser(UserRequestDTO dto) {
        User resultUser = users
                .stream()
                .filter(user -> user.getId() == dto.getId())
                .findFirst()
                .orElse(null);

        if (resultUser == null) {
            return null;
        }

        // Update fields on the found user (the list contains the same object)
        resultUser.setOrg(dto.getOrg());
        resultUser.setEmail(dto.getEmail());

        return resultUser;
    }

}
