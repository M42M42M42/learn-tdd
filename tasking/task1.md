# 用户名大于6位小于32，密码大于8位小于24位，且用户名没有被使用可以注册成功
### 1. given 有效的用户名和有效的密码 when 注册 then 注册成功
* Repository：given 非空用户名和非空密码 when 保存用户数据 then 成功保存到数据库
* Service：given 有效的用户名和有效的密码 when 注册 then 成功注册
* Controller： given 有效的用户名和有效密码 when 注册 then 返回成功，httpStatus:200
### 2. given 一个已经被注册的用户名和有效密码 when 注册 then 返回<用户名已使用>，httpStatus：400
* Repository：given 一个已经存在的用户名 when 根据用户查询 then 可以查询出用户数据
* Service：given 一个已经存在的用户名和有效密码 when 注册 then 抛出异常，异常信息<用户名已使用>
* Controller: given 一个已经存在的用户名和有效密码 when 注册 then 返回<用户名已使用>，httpStatus：400
### 3. given 一个小于6位的用户名和任意密码 when 注册 then 返回<用户名错误>，httpStatus：400
* Controller：given 一个小于6位的用户名和任意密码 when 注册 then 返回<用户名错误>， httpStatus:400
### 4. given 一个大于32位的用户名和任意密码 when 注册 then 返回<用户名错误>，httpStatus：400
* Controller：given 一个大于32位的用户名和任意密码 when 注册 then 返回<用户名错误>，httpStatus：400
### 5. given 一个有效的用户名和小于8位的密码 when 注册 then 返回<密码错误>，httpStatus：400
* Controller：given 一个有效的用户名和小于8位的密码 when 注册 then 返回<密码错误>，httpStatus：400
### 6. given 一个有效的用户名和大于24位的密码 when 注册 then 返回<密码错误>，httpStatus：400
* Controller：given 一个有效的用户名和大于24位的密码 when 注册 then 返回<密码错误>，httpStatus：400
### 7. given 无效的用户名和无效的密码 when 注册 then 返回<用户名错误>, httpStatus: 400
* Controller: given 无效的用户名和无效的密码 when 注册 then 返回<用户名错误>, httpStatus: 400

