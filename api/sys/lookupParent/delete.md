**接口名称：**

- 删除

**请求URL：**

{{host}}:{{port}}/sys/lookupParent/delete/{id}

**请求方式：**
- post

**参数：**

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|id    |是   |int|id|

**请求示例**

```
--request GET '{{host}}:{{port}}/lookupParent/delete/{id}'
--header 'Content-Type: application/json'
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