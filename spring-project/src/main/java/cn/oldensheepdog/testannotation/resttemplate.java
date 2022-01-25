package cn.oldensheepdog.testannotation;

/**
 * https://www.cnblogs.com/hunternet/p/12784437.html
 * Rest只是一种软件架构风格，最重要的概念是Resource，万物皆资源，资源是网络上的实体，实体展现出来的形式叫表现层
 * HTTP协议是无状态的Stateless，客户端如果想要操作服务器，必须通过某种手段让服务器端发生状态转化，就是表现层状态转化
 * GET POST PUT DELETE
 * URI来描述资源，使用Html，Json，XML等格式来表现，使用HTTP动词来操作资源来实现状态转化，使用HTTP状态码反应处理结果
 * GET 从服务器取出资源（一项或多项） —— 幂等
 * POST 在服务器新建一个资源 —— 非幂等
 * PUT 在服务器更新资源 （客户端提供更改后的完整资源）—— 幂等
 * PATCH 在服务器更新资源（客户端提供改变的属性）—— 幂等
 * DELETE 从服务器删除资源 —— 幂等
 * HEAD 获取资源的元数据
 * OPTIONS 获取信息，关于资源的哪些属性是客户端可以改变的
 * 200 OK - [GET]：服务器成功返回用户请求的数据，该操作是幂等的（Idempotent）。
 * 201 CREATED - [POST/PUT/PATCH]：用户新建或修改数据成功。
 * 202 Accepted - [*]：表示一个请求已经进入后台排队（异步任务）
 * 204 NO CONTENT - [DELETE]：用户删除数据成功。
 * 406 Not Acceptable - [GET]：用户请求的格式不可得（比如用户请求JSON格式，但是只有XML格式）。
 * 410 Gone -[GET]：用户请求的资源被永久删除，且不会再得到的。
 * 422 Unprocesable entity - [POST/PUT/PATCH] 当创建一个对象时，发生一个验证错误。
 * 500 INTERNAL SERVER ERROR - [*]：服务器发生错误，用户将无法判断发出的请求是否成功。
 * 面向资源不等于面向表单
 * 登录(login)和登出(logout)其实本质上只是对session资源的创建和删除；
 *
 * 登录和登出本质上只是对session资源的创建和删除
 * //登录——使用HTTP POST请求
 * POST /localhost/session
 * //登出——使用HTTP DELETE请求
 * DELETE /localhost/session
 * */

/**
 * POST和PUT的区别容易被简单地误认为"POST表示创建资源，PUT表示更新资源.但实际上两者都可以用来创建或是更新数据.单从技术上来说,他们并没有什么区别.
 * 但是在HTTP规范中POST是非等幂的,多次调用会产生不同的结果,比如:创建一个用户,由于网络原因或是其他原因多创建了几次,那么将会有多个用户被创建.
 * 而PUT id/456则会创建一个id为456的用户,多次调用还是会创建的结果是一样的,所以PUT是等幂的.
 * PATCH一般是用来局部更新资源的,假设我们有一个UserInfo，里面有userId， userName， userGender等10个字段。.
 * 可你的编辑功能因为需求，在某个特别的页面里只能修改userName，
 * */

/**
* CRUD
 * 增加 (Create)、 检索 (Retrieve)、更新 (Update)和删除 (Delete)
* */

/**
 * https://segmentfault.com/a/1190000018234763
 * General(不属于headers，只用于收集请求url和响应的status等信息)
 * * ResponseEntity.getStatusCode
 * */
public class resttemplate {
}
