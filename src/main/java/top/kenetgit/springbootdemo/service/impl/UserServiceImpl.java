package top.kenetgit.springbootdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.kenetgit.springbootdemo.mapper.TbUserMapper;
import top.kenetgit.springbootdemo.pojo.TbUser;
import top.kenetgit.springbootdemo.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private  TbUserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUser(TbUser user) throws Exception {
        userMapper.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUser(TbUser user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void deleteUser(String userId) {
        System.out.println("deleteUser");
    }

    @Override
    public TbUser queryUserById(int userId) {
        System.out.println("queryUserById");
        return null;
    }

    @Override
    public List<TbUser> queryUserList(TbUser user) {
        System.out.println("queryUserList");
        return null;
    }

    @Override
    public List<TbUser> queryUserListPage(TbUser user, Integer page, Integer pageSize) {
        System.out.println("queryUserListPage");
        return null;
    }

    @Override
    public TbUser queryUserByIdCustom(int userId) {
        System.out.println("queryUserByIdCustom");
        return null;
    }

    @Override
    public void saveUserTransactional(TbUser user) {
        System.out.println("saveUserTransactional");

    }
}
