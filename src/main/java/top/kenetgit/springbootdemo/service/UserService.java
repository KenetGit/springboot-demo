package top.kenetgit.springbootdemo.service;

import top.kenetgit.springbootdemo.pojo.TbUser;

import java.util.List;

public interface UserService {

    public void saveUser(TbUser user) throws Exception;

    public void updateUser(TbUser user);

    public void deleteUser(String userId);

    public TbUser queryUserById(int userId);

    public List<TbUser> queryUserList(TbUser user);

    public List<TbUser> queryUserListPage(TbUser user, Integer page, Integer pageSize);

    public TbUser queryUserByIdCustom(int userId);

    public void saveUserTransactional(TbUser user);

}
