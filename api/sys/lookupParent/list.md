**接口名称：**

- 标签列表

**请求URL：**

{{host}}:{{port}}/sys/lookupParent/list

**请求方式：**
- GET

**参数：**

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|name   |否  |string | 名称    |
|value   |否  |string |value值|
|page   |否  |Integer |页码|
|size   |否  |Integer |页数|

**请求示例**
```
--request GET '{{host}}:{{port}}/lookupParent/list?type=3&pageSize=1&currentPage=2&key=createTime&sort=desc'
--header 'Content-Type: application/json'

```

 **返回示例**
```json
{
    "code": 200,
    "message": "操作成功",
    "result": {
        "pageNum": 1,
        "pageSize": 20,
        "size": 1,
        "startRow": 1,
        "endRow": 1,
        "total": 1,
        "pages": 1,
        "list": [
            {
                "id": 3,
                "value": "value2",
                "name": "name2",
                "description": "description2",
                "appName": "appName2",
                "status": 1,
                "createBy": "海梁科技-王先生",
                "updateBy": null,
                "createTime": "2021-11-01 16:30:15",
                "updateTime": null
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
        "firstPage": 1,
        "lastPage": 1
    }
}
```
 **返回参数说明**

| 参数名      | 类型   | 说明                  |
| :---------- | :----- | --------------------- |
| value       | string | value值               |
| name        | string | 名称                  |
| description | string | 描述                  |
| appName     | string | 模块名称              |
| status      | int    | 状态 0-未启用，1-启用 |

 **返回错误码说明**

|错误码 |信息|说明|
|:----  |:----   |-----   |