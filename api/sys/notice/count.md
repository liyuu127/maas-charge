**接口名称：**

- 查询消息数量

**请求URL：**

/sys/notice/count

**请求方式：**
- GET

**参数：**

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|states   |否  |String |消息状态 1：未读；2：已读|
|startTime   |否  |LocalDateTime | 开始时间 |
|endTime |否  |LocalDateTime | 结束时间  |

**请求示例**
```
--request POST 'http://localhost:8010/notice/notice/count' 
--header 'Content-Type: application/json' 
--data-raw '{
}'
```

 **返回示例**
```json
{
    "code": 200,
    "msg": "success",
    "data": {
        "count": 2
    }
}
```
 **返回参数说明**

|参数名|类型|说明|
|:-----  |:-----|----- |
|sourceId  |Integer     |源事件id  |
|sourceType  |Integer     |源事件类型 |
|contentType  |Integer     |标题类型 |
|sourceContent  |String     |消息内容 |
|remindTime  |LocalDateTime     |消息发布时间 |
|createTime  |LocalDateTime     |消息创建时间 |
|noticeUserId  |Integer     |消息id |
|siteNoticeId  |Integer     |源消息id |
|state  |Integer     |消息状态 1：未读；2：已读 |
|readTime  |LocalDateTime     |阅读时间 |



 **返回错误码说明**

|错误码 |信息|说明|
|:----  |:----   |-----   |