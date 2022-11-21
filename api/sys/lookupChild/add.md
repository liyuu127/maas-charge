**接口名称：**

- 新增

**请求URL：**

{{host}}:{{port}}/sys/lookupChild/add

**请求方式：**

- post

**参数：**

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|pid|是|int|父级id|
|value    |是   |string|value值|
|name |是   |string|名称|
|description       |否   |string| 描述                  |
|orders      | 否 |string|内部排序|
|status        |是   |int|状态 0-未启用，1-启用|
|attr1 |否 |string|属性1|
|attr2 |否 |string|属性2|
|attr3 |否 |string|属性3|
|attr3 |否 |string|属性4|

**请求示例**
```
--request POST '{{host}}:{{port}}/lookupChild/add'
--header 'Content-Type: application/json'
{
    "pid":2,
    "value":"value2",
    "name":"name",
    "description":"description",
    "orders":100,
    "status":1,
    "attr1":null,
    "attr2":null,
    "attr3":null,
    "attr4":null
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