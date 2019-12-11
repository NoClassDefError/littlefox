package org.cie.littlefox;

import org.cie.littlefox.dao.UserDao;
import org.cie.littlefox.entity.User;
import org.cie.littlefox.vo.UserQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={LittlefoxApplication.class})
public class TestDao {
    @Autowired
    UserDao dao;

    @Test
    public void test(){
        User user = new User();
        user.setClient(true);
        user.setManager(false);
        user.setUsername("xioaming");
        user.setPassword("123456");
        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        dao.addAll(users);
    }

    @Test
    public void test2(){
        //UserQuery userQuery = new UserQuery();
        //userQuery.setPassword("123456");

        System.out.println(dao.getAll());
    }
}
