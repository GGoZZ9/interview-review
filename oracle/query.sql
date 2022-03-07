select s.stu_id from Student s inner join Class c on s.class_id=c.class_id inner join Teacher t on c.teacher_id=t.teacher_id where t.name='A'

--select s.stu_id from Student s inner join (Class c inner join Teacher t on c.teacher_id=t.teacher_id) on s.class_id=c.class_id where t.name='A'

select s.stu_id from Class c inner join Teacher t on c.teach_id=t.teacher_id and t.name='A' inner join Student s on s.class_id=c.class_id

select s.sname, s.sid from Student where s.sid not in (select t.tid,t.tname,c.cid, sc.sid from SC sc join Course c on c.cid=sc.cid join Teacher t on c.tid=t.tid where t.tname='Ye Ping')

(select s.class_id,s.teacher_id,s.stu_id as StuNumber, sum(case when s.gender='male' then 1 else 0 end) maleNumber from Student s group by s.class_id) Statistic select t.name, max(sta.maleNumber) from Teacher t jon
Statistic sta on t.teacher_id=sta.teacher_id

--查询男生最多的班级
1.利用自查询
select max(a.mailCount) from (select count(b.id), mailCount, basic_organ_id from t_card_basic b where b.basic_sex='男' group by b.basic_organ_id) a;
2.利用Oracle的特色rownum
select basic_organ_id,a,rownum from (select basic_organ_id,count(*) as a
from t_card_basic
where basic_sex='男'
group by basic_organ_id
order by a desc)
where rownum = 1;


--在select指定的字段要么就要包含在Group By语句的后面，作为分组的依据；要么就要被包含在聚合函数中。再多一个字段就会报错;group by里不能用别名，因为执行顺序FROM → WHERE → GROUP BY → SELECT
select category,sum(count) as totalcount from Info group by categroy;
--查询表中2，3，4年级中分别男女的总人数
select gradeId,sex,count(*)
from student
where gradeId in (2,3,4)
group by gradeId,sex;

1、 求个数：count
2、 求总和：sum
3、 求最大值：max
4、 求最小值：min
5、 求平均值：avg

执行效率上：
--列名为主键，count(列名)会比count(1)快
--列名不为主键，count(1)会比count(列名)快
--如果表多个列并且没有主键，则 count（1） 的执行效率优于 count（*）
--如果有主键，则 select count（主键）的执行效率是最优的
--如果表只有一个字段，则 select count（*）最优。

--https://zhuanlan.zhihu.com/p/72223558
有四个表，学生表（Student），课程表（Course），教师表（Teacher），以及成绩表（SC）
学生表（Student ）有四个字段 sid-学生id，sname-学生姓名，sage-学生年龄，ssex-学生性别
课程表（Course）有三个字段，cid-课程id，cname-课程名，tid-教师id
教师表（Teacher）有两个字段，tid-教师id，tname-教师姓名
成绩表（SC）有三个字段，sid-学生id，cid-课程id，score-成绩

1.查询"01"课程比"02"课程成绩高的学生的信息及课程分数
select * from Student right join
(select t1.sid,score1,score2
from
(select sid, score as score1 from sc where sc.cid='01') t1,
(select sid,score as score2 from sc where sc.cid='02') t2
where t1.sid=t2.sid and t1.score1>t2.score2) r
on Student.sid=r.sid;

1.1 查询存在" 01 "课程但可能不存在" 02 "课程的情况(不存在时显示为 null )
select *
from (select * from sc where sc.sid='01') t1
left join
(select * from sc where sc.cid='02') t2
on t1.sid=t2.sid;

1.2 查询同时存在01和02课程的情况
select *
from (select * from sc where sc.sid='01') t1,
(select * from sc where sc.sid='02') t2
where t1.sid=t2.sid;

1.3 查询选择了02课程但没有01课程的情况
select *
from sc
where sc.sid
not in (select sid from sc where sc.sid ='01')
and sc.sid='02';

2.查询平均成绩大于等于 60 分的同学的学生编号和学生姓名和平均成绩
select s.sid,sname,avg(sc.score)
from student s
inner join sc
on s.sid=sc.sid
group by sc.sid
having avg(sc.score)>=60;

3.查询在 SC 表存在成绩的学生信息
select distinct student.*
from sc.student
where student.sid=sc.sid;

4.查询所有同学的学生编号、学生姓名、选课总数、所有课程的成绩总和
select s.sid,s.sname,count(sc.cid),sum(sc.score)
from student s inner join sc
on s.sid=sc.sid
group by sc.sid;

5.查询「李」姓老师的数量
select count(*)
from teacher
where tname like ('李%');

6.查询学过「张三」老师授课的同学的信息
select s.*
from student s
inner join sc on s.sid = sc.sid
inner join course c on sc.sid=c.cid
inner join teacher t on t.tid=c.tid
where t.tname='张三';

7.查询没有学全所有课程的同学的信息
select s.*
from student s
where s.sid
not in (select sc.sid from sc group by sc.sid having count(cid)>3);

8.查询至少有一门课与学号为" 01 "的同学所学相同的同学的信息
select s.*
from sc
inner join student s
on sc.sid=s.sid
where sc.cid
in (select cid from sc where sid='01')
and sc.sid !='01'
group by sc.sid

10.查询没学过"张三"老师讲授的任一门课程的学生姓名
select sname
from student
where sid
not in(
select sid from sc
left join course on sc.cid=course.cid
left join teacher on course.tid=teacher.tid
where tname='张三'
);

12.检索" 01 "课程分数小于 60，按分数降序排列的学生信息
select s.*
from sc,student s
where cid='01' and score<60
and sc.sid=s.sid
order by score desc

14.查询各科成绩最高分、最低分和平均分,以如下形式显示：
以如下形式显示：课程 ID，课程 name，最高分，最低分，平均分，及格率，中等率，优良率，优秀率及格为>=60，中等为：70-80，优良为：80-90，优秀为：>=90
要求输出课程号和选修人数，查询结果按人数降序排列，若人数相同，按课程号升序排列
select
  cid as 课程ID,
  count(sid) as 课程人数,
  mas(score) as 最高分,
  min(score) as 最低分,
  avg(score) as 平均分,
  sum(及格) / count(sid) as 及格率,
  SUM(中等) / COUNT(sid) AS 中等率,
  SUM(优良) / COUNT(sid) AS 优良率,
  SUM(优秀) / COUNT(sid) AS 优秀率
from
  (select *,
     case
       when score >= 60
       then 1
       else 0
     end as 及格,
     case
       when score >= 70
       and score < 80
       then 1
       else 0
     end as 中等,
     case
       when score >= 90
       then 1
       else 0
     end as 优秀
   from sc) a
group by cid
order by count(sid) desc ,cid;

19.查询每门课程被选修的学生数
select cid,count(sid) as num
from sc
group by cid;

20.查询出只选修两门课程的学生学号和姓名
select sc.sid,sname
from sc
inner join student
on sc.sid=student.sid
group by sc.sid
having count(sc.cid)=2

21. 查询男生、女生人数
select ssex,count(ssex)
from student
group by ssex

SELECT SUM(CASE WHEN ssex='男' THEN 1 ELSE 0 END)AS 男生人数,
       SUM(CASE WHEN ssex='女' THEN 1 ELSE 0 END) AS 女生人数
FROM student;

25.查询每门课程的平均成绩，结果按平均成绩降序排列，平均成绩相同时，按课程编
select cid,avg(score)
from sc
group by cid
order by avg(score) desc, cid;

26.查询平均成绩大于等于 85 的所有学生的学号、姓名和平均成绩
select sc.sid,sname,avg(score) as 平均成绩
from sc,student
where sc.sid=student.sid
group by sc,sid
having 平均成绩>=85

27.查询课程名称为「数学」，且分数低于 60 的学生姓名和分数
select sname,score
from course c
inner join sc
on c.cid=sc.cid
and c.cname='数学'
and sc.score<60
inner join student s
on sc.sid=s.sid

34.成绩有重复的情况下，查询选修「张三」老师所授课程的学生中，成绩最高的学生
select student.*,sc.sid,score
from student
inner join sc
on student.sid=sc.sid
join course
on sc.cid=coures.cid
join teacher
on course.tid=teacher.tid
where tnmae='张三'
and score
in (select max(score) from sc inner join course on sc.cid=coures.cid join teacher on coures.tid=teacher.tid where tname='张三')；



