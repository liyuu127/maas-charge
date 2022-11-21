**接口名称：**

- ```
  分页查询国际化配置列表
  ```

**请求URL：**

{{host}}:{{port}}/sys/internationalization/list

**请求方式：**

- GET

**参数：**

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |

**请求示例**

```
--request GET 'http://localhost:8089/sys/internationalization/list'
--header 'Content-Type: application/json'

```

 **返回示例**
```json
{
  "code": 200,
  "message": "操作成功",
  "time": "2022-03-17 01:21:06",
  "data": {
    "pageNum": 1,
    "pageSize": 20,
    "size": 6,
    "startRow": 1,
    "endRow": 6,
    "total": 6,
    "pages": 1,
    "list": [
      {
        "id": 21,
        "code": "Health.Stagecoach.Business.CarNumberAlreadyExist",
        "value": "已存在相同编码车辆",
        "status": 1,
        "createTime": {
          "nano": 0,
          "year": 2022,
          "monthValue": 5,
          "dayOfMonth": 5,
          "hour": 9,
          "minute": 46,
          "second": 38,
          "dayOfWeek": "THURSDAY",
          "dayOfYear": 125,
          "month": "MAY",
          "chronology": {
            "id": "ISO",
            "calendarType": "iso8601"
          }
        },
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

| 参数名 | 类型   | 说明                  |
| :----- | :----- | --------------------- |
| id     | int    | id                    |
| code   | String | 编码                  |
| value  | string | 值                    |
| status | int    | 状态 0-未启用，1-启用 |

 **返回错误码说明**

|错误码 |信息|说明|
|:----  |:----   |-----   |