//package controller;
//
//
//import dao.JdbcUserDAO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//import quizdata.User;
//
//import java.util.List;
//
//@RestController
//public class QuizController {
//
//    @Autowired
//    JdbcUserDAO userDao;
//
//
//
//    @RequestMapping(path ="/quizList", method = RequestMethod.GET)
//    private List<User> getAllUsers() {
//      List<User> users = userDao.getAllUsers();
//        return users;
//    }
//
//}
