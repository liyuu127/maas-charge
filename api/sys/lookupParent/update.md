**接口名称：**

- 更新

**请求URL：**

{{host}}:{{port}}/sys/lookupParent/update

**请求方式：**
- post

**参数：**

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|id    |是   |Integer|id|
| value       | 是   | string  | value值               |
| name        | 是   | string  | 名称                  |
| description | 否   | string  | 描述                  |
| appName     |      | string  | 模块名称              |
| status      | 是   | int     | 状态 0-未启用，1-启用 |

**请求示例**
```
--request POST '{{host}}:{{port}}/lookupParent/update'
--header 'Content-Type: application/json'

{
    "id":2,
    "value":"value2",
    "name":"name",
    "description":"description",
    "appName":"appName",
    "status":0
}

```

 **返回示例**
```json
{
    "code": 200,
    "message": "操作成功",
    "result": {

    }
}

```
 **返回参数说明**

|参数名|类型|说明|
|:-----  |:-----|----- |



 **返回错误码说明**

|错误码 |信息|说明|
|:----  |:----   |-----   |
|300_001  |Health.Stagecoach.Business.ValueAlreadyExist   |新增的值已经存在   |