**接口名称：**

- 查询消息列表

**请求URL：**

/sys/notice/list

**请求方式：**
- GET

**参数：**

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|states   |否  |String |消息状态 1：未读；2：已读|
|startTime   |否  |LocalDateTime | 开始时间 |
|endTime |否  |LocalDateTime | 结束时间  |
|sourceType   |否  |Integer[]  |源事件类型集合|
|contentType   |否  |Integer[]  |标题类型集合|
|page   |否  |Integer |当前页|
|size   |否  |Integer |分页大小|

**请求示例**
```
--request POST 'http://localhost:8010/notice/notice/list' 
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
        "pageNum": 1,
        "pageSize": 20,
        "size": 2,
        "startRow": 1,
        "endRow": 2,
        "total": 2,
        "pages": 1,
        "list": [
            {
                "sourceId": 12,
                "sourceType": 1,
                "contentType": 1,
                "sourceContent": null,
                "remindTime": "2021-04-07T14:52:39",
                "createTime": "2021-04-07T14:52:39",
                "noticeUserId": 12,
                "siteNoticeId": 2,
                "state": 1,
                "readTime": null
            },
            {
                "sourceId": 12,
                "sourceType": 1,
                "contentType": 1,
                "sourceContent": null,
                "remindTime": "2021-04-07T14:52:39",
                "createTime": "2021-04-07T14:52:39",
                "noticeUserId": 14,
                "siteNoticeId": 2,
                "state": 1,
                "readTime": null
            }
        ],
        "prePage": 0,
        "nextPage": 0,
        "isFirstPage": true,
        "isLastPage": true,
        "hasPreviousPage": false,
        "hasNextPage": false,
        "navigatePages": 8,
        "navigatepageNums": [
            1
        ],
        "navigateFirstPage": 1,
        "navigateLastPage": 1,
        "lastPage": 1,
        "firstPage": 1
    }
}
```
 **返回参数说明**

|参数名|类型|说明|
|:-----  |:-----|----- |
|sourceId  |Integer     |源事件id  |
|sourceType  |Integer     |源事件类型 1:采购订单;2:质量反馈|
|contentType  |Integer     |内容类型 0:新订单;1:订单延期;2:订单预警;3:质量反馈; 4:质量反馈数量告警;|
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