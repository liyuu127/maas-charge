**接口名称：**

- 标签列表

**请求URL：**

{{host}}:{{port}}/sys/lookupChild/list

**请求方式：**
- GET

**参数：**

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|pid   |是  |int | 父级id  |
|page   |否  |Integer |页码|
|size   |否  |Integer |页数|

**请求示例**
```
--request GET '{{host}}:{{port}}/lookupChild/list?type=3&pageSize=1&currentPage=2&key=createTime&sort=desc'
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
        "size": 2,
        "startRow": 1,
        "endRow": 2,
        "total": 2,
        "pages": 1,
        "list": [
            {
                "id": 2,
                "pid": 2,
                "value": "value3",
                "name": "name",
                "description": "description",
                "orders": "100",
                "status": 1,
                "attr1": null,
                "attr2": null,
                "attr3": null,
                "attr4": null,
                "createBy": "海梁科技-王先生",
                "updateBy": "海梁科技-王先生",
                "createTime": "2021-11-01 16:54:19",
                "updateTime": "2021-11-01 17:01:21"
            },
            {
                "id": 3,
                "pid": 2,
                "value": "value2",
                "name": "name",
                "description": "description",
                "orders": "100",
                "status": 1,
                "attr1": null,
                "attr2": null,
                "attr3": null,
                "attr4": null,
                "createBy": "海梁科技-王先生",
                "updateBy": "海梁科技-王先生",
                "createTime": "2021-11-01 16:56:11",
                "updateTime": "2021-11-01 16:57:25"
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
| pid         | int    | 父级id                |
| value       | string | value值               |
| name        | string | 名称                  |
| description | string | 描述                  |
| orders      | string | 内部排序              |
| status      | int    | 状态 0-未启用，1-启用 |
| attr1       | string | 属性1                 |
| attr2       | string | 属性2                 |
| attr3       | string | 属性3                 |
| attr3       | string | 属性4                 |

 **返回错误码说明**

|错误码 |信息|说明|
|:----  |:----   |-----   |