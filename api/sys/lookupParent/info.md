**接口名称：**

- 标签详情

**请求URL：**

{{host}}:{{port}}/sys/lookupParent/info

**请求方式：**
- GET

**参数：**

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|value   |是  |string |key|

**请求示例**

```
--request GET '{{host}}:{{port}}/lookupParent/info?value=orderVehicleNumber
--header 'Content-Type: application/json'

```

 **返回示例**
```json
{
    "code": 200,
    "message": "操作成功",
    "result": {
        "id": 15,
        "value": "orderVehicleNumber",
        "name": "受令车次",
        "description": "受令车次",
        "appName": "行车调度",
        "status": 1,
        "createBy": "海梁科技-管理员",
        "updateBy": "海梁科技-管理员",
        "createTime": "2021-12-06 15:16:06",
        "updateTime": "2021-12-06 15:16:22"
    }
}
```
 **返回参数说明**

| 参数名      | 类型   | 说明                  |
| :---------- | :----- | --------------------- |
| id          | int    | id                    |
| value       | string | value值               |
| name        | string | 名称                  |
| description | string | 描述                  |
| appName     | string | 模块名称              |
| status      | int    | 状态 0-未启用，1-启用 |

 **返回错误码说明**

|错误码 |信息|说明|
|:----  |:----   |-----   |