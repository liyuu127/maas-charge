**接口名称：**

- 阅读消息

**请求URL：**

/sys/notice/read

**请求方式：**
- GET

**参数：**

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|noticeUserIds   |是  |Integer[] |阅读的消息id数组|
**请求示例**
```
--request POST 'http://localhost:8010/notice/notice/read' 
--header 'Content-Type: application/json' 
--data-raw '{
                "noticeUserIds":[12,14]
            }'
```

 **返回示例**
```json
{
    "code": 200,
    "msg": "success",
    "data": {}
}
```
 **返回参数说明**

|参数名|类型|说明|
|:-----  |:-----|----- |




 **返回错误码说明**

|错误码 |信息|说明|
|:----  |:----   |-----   |