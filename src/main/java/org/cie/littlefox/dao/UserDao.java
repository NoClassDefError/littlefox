package org.cie.littlefox.dao;

import org.cie.littlefox.entity.User;
import org.cie.littlefox.util.MyDataBase;
import org.cie.littlefox.vo.UserQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class UserDao {

    @Autowired
    private MyDataBase<ArrayList<User>> myDataBase;

    public User getUser(UserQuery user) {
        ArrayList<User> list = getAll();
        for (User user1 : list)
            if (user1.getUsername().equals(user.getUsername())) if (user1.getPassword().equals(user.getPassword()))
                return user1;
        return null;
    }

    public void addUser(User user) {
        ArrayList<User> list = getAll();
        list.add(user);
        myDataBase.save(list);
    }

    public void addAll(ArrayList<User> users){
        myDataBase.save(users);
    }

    public ArrayList<User> getAll(){
        return myDataBase.get();
    }

    public void deleteUser(UserQuery user) {
        ArrayList<User> list = getAll();
        for (User user1 : list)
            if (user1.getUsername().equals(user.getUsername())) if (user1.getPassword().equals(user.getPassword()))
                list.remove(user1);
    }

    public void updateUser(User user) {
        ArrayList<User> list = getAll();
        for (User user1 : list)
            if (user1.getUsername().equals(user.getUsername())) if (user1.getPassword().equals(user.getPassword())){
                list.remove(user1);
                list.add(user);
            }
    }
}
