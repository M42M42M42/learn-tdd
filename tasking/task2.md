# 用户使用正确的用户名和密码可以重新登录，用户名或密码错误提示用"用户名或密码错误"
``` 标题是按照业务做的tasking，每个业务task下面是按照技术做的tasking ```
### 1. given 已经注册过的用户名和正确的密码 when 登录 then 登录成功
* Repository: given 已经注册过的用户名 when 查询密码 then 成功查询密码
* Service： given 已经注册过的用户名和正确的密码 when 登录 then 成功登录
* Controller： given 已经注册过的用户名和正确的密码 when 登录 then 返回成功，httpStatus：200
### 2。 given 已经注册过的用户名和错误的密码 when 登录 then 返回<用户名或密码错误>，httpStatus：400
* Repository： given 已经注册过的用户名 when 查询密码 then 成功查询密码
* Service： given 已经注册过的用户名和错误的密码 when 登录 then 抛出异常，异常信息<用户名或密码错误>
* Controller： given 已经注册过的用户名和错误的密码 when 登录 then 返回<用户名或密码错误>，httpStatus：400
### 3. given 没有注册过的用户名和任意密码 when 登录 then 返回<用户名或密码错误>， httpStatus：400
* Repository： given 没有注册过的用户名 when 查询密码 then 查询失败
* Service： given 没有注册过的用户名和任意密码 when 登录 then 抛出异常，异常信息<用户名或密码错误>
* Controller： given 没有注册过的用户名和任意密码 when 登录 then 返回<用户名或密码错误>，httpStatus：400
