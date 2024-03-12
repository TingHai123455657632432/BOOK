package test;

import entity.Student;
import entity.Teacher;
import service.*;
import util.DateUtil;

import java.text.ParseException;
import java.util.Scanner;

/**
 * @author：邾头肉
 * @date：2024/3/9
 */
public class TeachManage {
    public static void main(String[] args) throws ParseException {
        boolean manager = false;
        boolean teacher = false;
        boolean student = false;
        String studentclass=null;
        String teacherclass=null;
        String nowstudentname=null;
        String c;
        int nowTid=0;
        int nowSid=0;
        boolean flag = true;
        do{
            System.out.println("-------------------------");
            System.out.println("欢迎使用教务管理系统");
            System.out.println("1.管理员");
            System.out.println("2.老师");
            System.out.println("3.学生");
            System.out.println("4.退出系统");
            System.out.println("-------------------------");
            Scanner sc=new Scanner(System.in);
            System.out.println("请选择您的身份：");
            int role=sc.nextInt();
            switch (role) {
                case 1:
                    System.out.println("请输入管理员账号");
                    String maccount = sc.next();
                    System.out.println("请输入管理员密码");
                    String mpassword = sc.next();
                    if (ServiceForManager.login(maccount, mpassword) !=0) {
                        System.out.println("登录成功");
                        manager = true;
                        teacher=false;
                        student=false;
                    } else {
                        System.out.println("登录失败");
                    }
                    break;
                case 2:
                    System.out.println("请输入老师账号");
                    String taccount = sc.next();
                    System.out.println("请输入老师密码");
                    String tpassword = sc.next();
                    if (ServiceForTeacher.login(taccount, tpassword) !=0) {
                        System.out.println("登录成功");
                        nowTid=ServiceForTeacher.login(taccount, tpassword);
                        teacherclass=ServiceForTeacher.getClassByTeacher(nowTid);
                        teacher = true;
                        student=false;
                        manager=false;
                    } else {
                        System.out.println("登录失败");
                    }
                    break;
                case 3:
                    System.out.println("请输入学生账号");
                    String saccount = sc.next();
                    System.out.println("请输入学生密码");
                    String spassword = sc.next();
                    if (ServiceForStudent.login(saccount, spassword)!=0) {
                        System.out.println("登录成功");
                        nowSid=ServiceForStudent.login(saccount, spassword);
                        studentclass=ServiceForStudent.getClassByStudent(nowSid);
                        nowstudentname=ServiceForStudent.getStudentNameByStudent(nowSid);
                        student = true;
                        teacher=false;
                        manager=false;
                    } else {
                        System.out.println("登录失败");
                    }
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("请输入正确的身份");
                    break;
            }
            if(manager){
                boolean manage=true;
                do{

//                    查看所有班级信息
//                    查看指定班级信息
//                    修改指定班级信息
//                    添加班级信息
//                    删除指定班级信息
//                    查看所有课程信息
//                    查看指定课程信息
//                    修改指定课程信息
//                    添加课程信息
//                    删除指定课程信息
//                    查看所有老师信息
//                    查看指定老师信息
//                    修改指定老师信息
//                    删除指定老师信息
//                    添加老师信息
//                    查看所有学生信息
//                    查看指定学生信息
//                    添加学生信息
//                    修改指定学生信息
//                    删除指定学生信息
//                    查看所有学生成绩信息
//                    查看指定学生成绩信息
//                    查看指定班级所有学生成绩信息
//                    查看所有班级指定科目成绩信息
//                    查看指定班级指定科目成绩信息
                    System.out.println("1.查看所有班级信息");
                    System.out.println("2.查看指定班级信息");
                    System.out.println("3.修改指定班级信息");
                    System.out.println("4.添加班级信息");
                    System.out.println("5.删除指定班级信息");
                    System.out.println("6.查看所有课程信息");
                    System.out.println("7.查看指定课程信息");
                    System.out.println("8.修改指定课程信息");
                    System.out.println("9.添加课程信息");
                    System.out.println("10.删除指定课程信息");
                    System.out.println("11.查看所有老师信息");
                    System.out.println("12.查看指定老师信息");
                    System.out.println("13.修改指定老师信息");
                    System.out.println("14.删除指定老师信息");
                    System.out.println("15.添加老师信息");
                    System.out.println("16.查看所有学生信息");
                    System.out.println("17.查看指定学生信息");
                    System.out.println("18.添加学生信息");
                    System.out.println("19.修改指定学生信息");
                    System.out.println("20.删除指定学生信息");
                    System.out.println("21.查看所有学生成绩信息");
                    System.out.println("22.查看指定学生成绩信息");
                    System.out.println("23.查看指定班级所有学生成绩信息");
                    System.out.println("24.查看所有班级指定科目成绩信息");
                    System.out.println("25.查看指定班级指定科目成绩信息");
                    System.out.println("26.退出登录");
                    System.out.println("请选择：");
                    int mchoose=sc.nextInt();
                    switch (mchoose) {
                        case 1:
                            ServiceForClass.queryAllClass();
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c = sc.next();
                            if (c.equals("0")) {
                                flag = false;
                                manage = false;
                            }
                            break;
                        case 2:
                            System.out.println("请输入班级名称：");
                            String cname = sc.next();
                            ServiceForClass.queryClass(cname);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c = sc.next();
                            if (c.equals("0")) {
                                flag = false;
                                manage = false;
                            }
                            break;
                        case 3:
                            System.out.println("请输入班级名称：");
                            String cname1 = sc.next();
                            System.out.println("请输入班主任编号：");
                            int tid = sc.nextInt();
                            System.out.println("请输入班级学生：");
                            int sid = sc.nextInt();
                            ServiceForClass.updateClass(cname1, tid, sid);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c = sc.next();
                            if (c.equals("0")) {
                                flag = false;
                                manage = false;
                            }
                            break;
                        case 4:
                            System.out.println("请输入班级名称：");
                            String cname2 = sc.next();
                            System.out.println("请输入要加入的班主任：");
                            int tid1 = sc.nextInt();
                            System.out.println("请输入班级学生编号：");
                            int sid1 = sc.nextInt();
                            ServiceForClass.addClass(cname2, tid1, sid1);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c = sc.next();
                            if (c.equals("0")) {
                                flag = false;
                                manage = false;
                            }
                            break;
                        case 5:
                            System.out.println("请输入班级名称：");
                            String cname3 = sc.next();
                            ServiceForClass.deleteClass(cname3);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c = sc.next();
                            if (c.equals("0")) {
                                flag = false;
                                manage = false;
                            }
                            break;
                        case 6:
                            ServiceForCourse.queryAllCourse();
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c = sc.next();
                            if (c.equals("0")) {
                                flag = false;
                                manage = false;
                            }
                            break;
                        case 7:
                            System.out.println("请输入课程编号：");
                            int cid = sc.nextInt();
                            ServiceForCourse.queryCourse(cid);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c= sc.next();
                            if (c.equals("0")) {
                                flag = false;
                                manage = false;
                            }
                            break;
                        case 8:
                            System.out.println("请输入课程编号：");
                            int cid1 = sc.nextInt();
                            System.out.println("请输入课程名称：");
                            String name = sc.next();
                            System.out.println("请输入任课老师编号：");
                            int tid2 = sc.nextInt();
                            ServiceForCourse.updateCourse(cid1, name, tid2);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c = sc.next();
                            if (c.equals("0")) {
                                flag = false;
                                manage = false;
                            }
                            break;
                        case 9:
                            System.out.println("请输入课程名称：");
                            String cname11 = sc.next();
                            System.out.println("请输入任课老师编号：");
                            int tid11 = sc.nextInt();
                            ServiceForCourse.addCourse(cname11, tid11);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c = sc.next();
                            if (c.equals("0")) {
                                flag = false;
                                manage = false;
                            }
                            break;
                        case 10:
                            System.out.println("请输入课程编号：");
                            int cid11 = sc.nextInt();
                            ServiceForCourse.deleteCourse(cid11);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c = sc.next();
                            if (c.equals("0")) {
                                flag = false;
                                manage = false;
                            }
                            break;
                        case 11:
                            ServiceForTeacher.queryAllTeacher();
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c = sc.next();
                            if (c.equals("0")) {
                                flag = false;
                                manage = false;
                            }
                            break;
                        case 12:
                            System.out.println("请输入老师编号：");
                            int tid12 = sc.nextInt();
                            ServiceForTeacher.queryTeacher(tid12);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c = sc.next();
                            if (c.equals("0")) {
                                flag = false;
                                manage = false;
                            }
                            break;
                        case 13:
                            System.out.println("请输入老师编号：");
                            int tid13 = sc.nextInt();
                            System.out.println("请输入老师姓名：");
                            String tname = sc.next();
                            System.out.println("请输入老师账号：");
                            String taccount = sc.next();
                            System.out.println("请输入老师密码：");
                            String tpassword = sc.next();
                            System.out.println("请输入老师电话：");
                            String tphone = sc.next();
                            ServiceForTeacher.updateTeacher(new Teacher(tid13, tname, taccount, tpassword, tphone));
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c = sc.next();
                            if (c.equals("0")) {
                                flag = false;
                                manage = false;
                            }
                            break;
                        case 14:
                            System.out.println("请输入要删除的老师编号");
                            int tid14 = sc.nextInt();
                            ServiceForTeacher.deleteTeacher(tid14);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c = sc.next();
                            if (c.equals("0")) {
                                flag = false;
                                manage = false;
                            }
                            break;
                        case 15:
                            Teacher teacher1 = new Teacher();
                            System.out.println("请输入老师姓名");
                            teacher1.setTname(sc.next());
                            System.out.println("请输入老师账号");
                            teacher1.setTaccount(sc.next());
                            System.out.println("请输入老师密码");
                            teacher1.setTpassword(sc.next());
                            System.out.println("请输入老师电话");
                            teacher1.setTphone(sc.next());
                            ServiceForTeacher.addTeacher(teacher1);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c = sc.next();
                            if (c.equals("0")) {
                                flag = false;
                                manage = false;
                            }
                            break;
                        case 16:
                            ServiceForStudent.queryAllStudent();
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c = sc.next();
                            if (c.equals("0")) {
                                flag = false;
                                manage = false;
                            }
                            break;
                        case 17:
                            System.out.println("请输入学生所在班级");
                            String sname1 = sc.next();
                            System.out.println("请输入学生姓名");
                            String sname = sc.next();
                            ServiceForStudent.queryStudent(sname, sname1);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c = sc.next();
                            if (c.equals("0")) {
                                flag = false;
                                manage = false;
                            }
                            break;
                        case 18:
                            Student student1 = new Student();
                            System.out.println("请输入学生姓名");
                            student1.setSname(sc.next());
                            System.out.println("请输入学生性别");
                            student1.setSsex(sc.next());
                            System.out.println("请输入学生出生日期");
                            student1.setSbirth(DateUtil.strToutilDate(sc.next()));
                            System.out.println("请输入学生地址");
                            student1.setSaddress(sc.next());
                            System.out.println("请输入学生账号");
                            student1.setSaccount(sc.next());
                            System.out.println("请输入学生密码");
                            student1.setSpassword(sc.next());
                            boolean flag1 = ServiceForStudent.addStudent(student1);
                            if (flag1) {
                                System.out.println("添加成功");
                                System.out.println("请输入要加入哪个班级");
                                String classname = sc.next();
                                int studentid = ServiceForStudent.getNewStudentId();
                                ServiceForStudent.addStudentToClass(studentid, classname);
                            } else {
                                System.out.println("添加失败");
                            }
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c = sc.next();
                            if (c.equals("0")) {
                                flag = false;
                                manage = false;
                            }
                            break;
                        case 19:
//                                修改指定学生信息
                            System.out.println("请输入要修改的学生编号");
                            int studentid1 = sc.nextInt();
                            Student student11 = new Student();
                            System.out.println("请输入学生姓名");
                            student11.setSname(sc.next());
                            System.out.println("请输入学生性别");
                            student11.setSsex(sc.next());
                            System.out.println("请输入学生出生日期");
                            student11.setSbirth(DateUtil.strToutilDate(sc.next()));
                            System.out.println("请输入学生地址");
                            student11.setSaddress(sc.next());
                            System.out.println("请输入学生账号");
                            student11.setSaccount(sc.next());
                            System.out.println("请输入学生密码");
                            student11.setSpassword(sc.next());
                            ServiceForStudent.updateStudent(student11);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c = sc.next();
                            if (c.equals("0")) {
                                flag = false;
                                manage = false;
                            }
                            break;
                        case 20:
                            System.out.println("请输入要删除的学生编号");
                            int studentid2 = sc.nextInt();
                            ServiceForStudent.deleteStudent(studentid2);
                            ServiceForClass.deleteClassByStudent(studentid2);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c = sc.next();
                            if (c.equals("0")) {
                                flag = false;
                                manage = false;
                            }
                            break;
                        case 21:
//                            查看所有学生成绩信息
                            ServiceForStudent.queryAllScore();
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c = sc.next();
                            if (c.equals("0")) {
                                flag = false;
                                manage = false;
                            }
                            break;
                        case 22:
                            System.out.println("请输入要查询的科目");
                            String course = sc.next();
                            ServiceForStudent.queryAllScoreByCourse(course);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c = sc.next();
                            if (c.equals("0")) {
                                flag = false;
                                manage = false;
                            }
                            break;
                        case 23:
//                                查看指定班级所有学生成绩信息
                            System.out.println("请输入要查询的班级");
                            String classname = sc.next();
                            ServiceForStudent.queryAllStudentAllSubject(classname);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c = sc.next();
                            if (c.equals("0")) {
                                flag = false;
                                manage = false;
                            }
                            break;
                        case 24:
//                                查看所有班级指定科目成绩信息
                            System.out.println("请输入要查询的科目");
                            String course1 = sc.next();
                            ServiceForStudent.queryAllScoreByCourse(course1);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c = sc.next();
                            if (c.equals("0")) {
                                flag = false;
                                manage = false;
                            }
                            break;
                        case 25:
                            System.out.println("请输入要查询的班级");
                            String classname1 = sc.next();
                            System.out.println("请输入要查询的科目");
                            String coursename = sc.next();
                            ServiceForStudent.queryScoreByClassAndCourse(coursename, classname1);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c = sc.next();
                            if (c.equals("0")) {
                                flag = false;
                                manage = false;
                            }
                            break;
                        case 26:
                            manage = false;
                            manager = false;
                            break;
                        default:
                            System.out.println("输入有误，请重新输入");
                            break;
                    }
                }while(manage);
            }else if(teacher){
//                查看自己的信息
//                修改自己的信息
//                删除自己的信息
//                查看自己班级所有学生信息
//                查看自己班级指定学生信息
//                添加自己班级学生信息
//                修改自己班级指定学生信息
//                删除自己班级指定学生信息
//                查看自己班级所有学生所有科目成绩信息
//                查看自己班级所有学生指定科目成绩信息
//                查看自己班级指定学生所有科目成绩信息
//                查看自己班级指定学生指定科目成绩信息
                boolean teach = true;
                do {
                    System.out.println("-----------------");
                    System.out.println("1.查看自己的信息");
                    System.out.println("2.修改自己的信息");
                    System.out.println("3.删除自己的信息");
                    System.out.println("4.查看自己班级所有学生信息");
                    System.out.println("5.查看自己班级指定学生信息");
                    System.out.println("6.添加自己班级学生信息");
                    System.out.println("7.修改自己班级指定学生信息");
                    System.out.println("8.删除自己班级指定学生信息");
                    System.out.println("9.查看自己班级所有学生所有科目成绩信息");
                    System.out.println("10.查看自己班级所有学生指定科目成绩信息");
                    System.out.println("11.查看自己班级指定学生所有科目成绩信息");
                    System.out.println("12.查看自己班级指定学生指定科目成绩信息");
                    System.out.println("13.退出登录");
                    System.out.println("请输入要执行的操作");
                    int op = sc.nextInt();
                    switch (op) {
                        case 1:
                            ServiceForTeacher.queryTeacher(nowTid);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c=sc.next();
                            if(c.equals("0")){
                                flag=false;
                                teach=false;
                            }
                            break;
                        case 2:
                            System.out.println("请输入要修改的教师姓名");
                            String tname = sc.next();
                            System.out.println("请输入要修改的教师账号");
                            String taccount = sc.next();
                            System.out.println("请输入要修改的教师密码");
                            String tpassword = sc.next();
                            System.out.println("请输入要修改的教师电话");
                            String tphone = sc.next();
                            Teacher teacher1 = new Teacher(nowTid, tname, taccount, tpassword, tphone);
                            ServiceForTeacher.updateTeacher(teacher1);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c=sc.next();
                            if(c.equals("0")){
                                flag=false;
                                teach=false;
                            }
                            break;
                        case 3:
                            ServiceForTeacher.deleteTeacher(nowTid);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c=sc.next();
                            if(c.equals("0")){
                                flag=false;
                                teach=false;
                            }
                            teach = false;
                            break;
                        case 4:
                            ServiceForStudent.queryclassAll(teacherclass);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c=sc.next();
                            if(c.equals("0")){
                                flag=false;
                                teach=false;
                            }
                            break;
                        case 5:
                            System.out.println("请输入要查询的学生姓名");
                            String sname = sc.next();
                            ServiceForStudent.queryStudent(sname, teacherclass);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c=sc.next();
                            if(c.equals("0")){
                                flag=false;
                                teach=false;
                            }
                            break;
                        case 6:
                            System.out.println("请输入要添加的学生姓名");
                            String sname1 = sc.next();
                            System.out.println("请输入要添加的学生性别");
                            String ssex = sc.next();
                            System.out.println("请输入要添加的学生出生日期");
                            String sbirth = sc.next();
                            System.out.println("请输入要添加的学生地址");
                            String saddress = sc.next();
                            System.out.println("请输入要添加的学生账号");
                            String saccount = sc.next();
                            System.out.println("请输入要添加的学生密码");
                            String spassword = sc.next();
                            Student student3 = new Student(sname1, DateUtil.strDateTosqlDate(sbirth), ssex, saccount, spassword, saddress);
                            ServiceForStudent.addStudent(student3);
                            ServiceForStudent.addStudentToClass(ServiceForStudent.getNewStudentId(), teacherclass);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c=sc.next();
                            if(c.equals("0")){
                                flag=false;
                                teach=false;
                            }
                            break;
                        case 7:
                            System.out.println("请输入要修改的学生编号");
                            int sid = sc.nextInt();
                            System.out.println("请输入要修改的学生姓名");
                            String sname2 = sc.next();
                            System.out.println("请输入要修改的学生性别");
                            String ssex2 = sc.next();
                            System.out.println("请输入要修改的学生出生日期");
                            String sbirth2 = sc.next();
                            System.out.println("请输入要修改的学生地址");
                            String saddress2 = sc.next();
                            System.out.println("请输入要修改的学生账号");
                            String saccount2 = sc.next();
                            System.out.println("请输入要修改的学生密码");
                            String spassword2 = sc.next();
                            Student student4 = new Student(sname2, DateUtil.strDateTosqlDate(sbirth2), ssex2, saccount2, spassword2, saddress2);
                            ServiceForStudent.updateStudent(student4);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c=sc.next();
                            if(c.equals("0")){
                                flag=false;
                                teach=false;
                            }
                            break;
                        case 8:
                            System.out.println("请输入要删除的学生姓名");
                            String sname3 = sc.next();
                            ServiceForStudent.deleteStudent(sname3, teacherclass);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c=sc.next();
                            if(c.equals("0")){
                                flag=false;
                                teach=false;
                            }
                            break;
                        case 9:
                            ServiceForStudent.queryAllScoreByCourse(teacherclass);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c=sc.next();
                            if(c.equals("0")){
                                flag=false;
                                teach=false;
                            }
                            break;
                        case 10:
                            System.out.println("请输入要查询的课程名称");
                            String course = sc.next();
                            ServiceForStudent.queryScoreByClassAndCourse(course, teacherclass);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c=sc.next();
                            if(c.equals("0")){
                                flag=false;
                                teach=false;
                            }
                            break;
                        case 11:
                            System.out.println("请输入要查询的学生姓名");
                            String sname4 = sc.next();
                            ServiceForStudent.queryStudentAllSubject(sname4);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c=sc.next();
                            if(c.equals("0")){
                                flag=false;
                                teach=false;
                            }
                            break;
                        case 12:
                            System.out.println("请输入学生姓名");
                            String sname5 = sc.next();
                            System.out.println("请输入要查询的科目");
                            String subject = sc.next();
                            ServiceForStudent.queryStudentSubject(sname5, subject);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c=sc.next();
                            if(c.equals("0")){
                                flag=false;
                                teach=false;
                            }
                            break;
                        case 13:
                            teach = false;
                            teacher=false;
                            break;
                    }
                }while(teach);
            }else if(student){
                boolean study=true;
                do{
//                    查看自己的信息
//                    修改自己的信息
//                    删除自己的信息
//                    查看自己所有科目成绩信息
//                    查看自己指定科目成绩信息
//                    查看自己班级所有学生所有科目成绩信息
//                    查看自己班级所有学生指定科目成绩信息
//                    查看自己班级指定学生所有科目成绩信息
//                    查看自己班级指定学生指定科目成绩信息
                    System.out.println("---------------------------------");
                    System.out.println("1.查看自己的信息");
                    System.out.println("2.修改自己的信息");
                    System.out.println("3.删除自己的信息");
                    System.out.println("4.查看自己所有科目成绩信息");
                    System.out.println("5.查看自己指定科目成绩信息");
                    System.out.println("6.查看自己班级所有学生所有科目成绩信息");
                    System.out.println("7.查看自己班级所有学生指定科目成绩信息");
                    System.out.println("8.查看自己班级指定学生所有科目成绩信息");
                    System.out.println("9.查看自己班级指定学生指定科目成绩信息");
                    System.out.println("10.退出");
                    System.out.println("---------------------------------");
                    System.out.println("请输入你的操作");
                    int choice = sc.nextInt();
                    switch (choice){
                        case 1:
                            ServiceForStudent.queryStudent(nowSid);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c=sc.next();
                            if(c.equals("0")){
                                flag=false;
                                study=false;
                            }
                            break;
                        case 2:
                            System.out.println("请输入要修改的学生姓名");
                            String sname = sc.next();
                            System.out.println("请输入要修改的学生性别");
                            String ssex = sc.next();
                            System.out.println("请输入要修改的学生出生日期");
                            String sbirth = sc.next();
                            System.out.println("请输入要修改的学生地址");
                            String saddress = sc.next();
                            System.out.println("请输入要修改的学生账号");
                            String saccount = sc.next();
                            System.out.println("请输入要修改的学生密码");
                            String spassword = sc.next();
                            Student student2 = new Student(nowSid,sname, DateUtil.strDateTosqlDate(sbirth), ssex, saccount, spassword, saddress);
                            ServiceForStudent.updateStudent(student2);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c=sc.next();
                            if(c.equals("0")){
                                flag=false;
                                study=false;
                            }
                            break;
                        case 3:
                            ServiceForStudent.deleteStudent(nowSid);
                            study=false;
                            student=false;
                            break;
                        case 4:
                            ServiceForStudent.queryStudentAllSubject(nowstudentname);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c=sc.next();
                            if(c.equals("0")){
                                flag=false;
                                study=false;
                            }
                            break;
                        case 5:
                            System.out.println("请输入要查看的科目名称");
                            String subject = sc.next();
                            ServiceForStudent.queryStudentSubject(nowstudentname, subject);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c=sc.next();
                            if(c.equals("0")){
                                flag=false;
                                study=false;
                            }
                            break;
                        case 6:
                            ServiceForStudent.queryAllStudentAllSubject(studentclass);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c=sc.next();
                            if(c.equals("0")){
                                flag=false;
                                study=false;
                            }
                            break;
                        case 7:
                            System.out.println("请输入要查看的科目名称");
                            String subject1 = sc.next();
                            ServiceForStudent.queryAllStudentSubject(studentclass, subject1);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c=sc.next();
                            if(c.equals("0")){
                                flag=false;
                                study=false;
                            }
                            break;
                        case 8:
                            System.out.println("请输入指定学生姓名");
                            String sname1 = sc.next();
                            ServiceForStudent.queryStudentAllSubject(sname1);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c=sc.next();
                            if(c.equals("0")){
                                flag=false;
                                study=false;
                            }
                            break;
                        case 9:
                            System.out.println("请输入学生姓名");
                            String sname2 = sc.next();
                            System.out.println("请输入科目名称");
                            String subject2 = sc.next();
                            ServiceForStudent.queryStudentSubject(sname2, subject2);
                            System.out.println("输入0退出系统，输入任意键返回上一级");
                            c=sc.next();
                            if(c.equals("0")){
                                flag=false;
                                study=false;
                            }
                            break;
                        case 10:
                            student = false;
                            study=false;
                            break;
                    }
                }while (study);
            }
        }while (flag);
    }
}
