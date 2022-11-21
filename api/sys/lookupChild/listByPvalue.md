**接口名称：**

- 标签列表

**请求URL：**

{{host}}:{{port}}/sys/lookupChild/listByPvalue

**请求方式：**
- GET

**参数：**

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|value   |是  | string | 父级key值 |

**请求示例**
```
--request GET '{{host}}:{{port}}/lookupChild/listByPvalue?value=contactRail'
--header 'Content-Type: application/json'

```

 **返回示例**
```json
{
    "code": 200,
    "message": "操作成功",
    "result": [
        {
            "id": 19,
            "pid": 11,
            "value": "1",
            "name": "未电通",
            "description": "未电通",
            "orders": "1",
            "status": 1,
            "attr1": "",
            "attr2": "",
            "attr3": "",
            "attr4": "",
            "createBy": "海梁科技-管理员",
            "updateBy": null,
            "createTime": "2021-11-18 15:21:57",
            "updateTime": null
        },
        {
            "id": 20,
            "pid": 11,
            "value": "2",
            "name": "带电",
            "description": "带电",
            "orders": "2",
            "status": 1,
            "attr1": "",
            "attr2": "",
            "attr3": "",
            "attr4": "",
            "createBy": "海梁科技-管理员",
            "updateBy": null,
            "createTime": "2021-11-18 15:22:12",
            "updateTime": null
        },
        {
            "id": 21,
            "pid": 11,
            "value": "3",
            "name": "停电不挂线",
            "description": "停电不挂线",
            "orders": "3",
            "status": 1,
            "attr1": "",
            "attr2": "",
            "attr3": "",
            "attr4": "",
            "createBy": "海梁科技-管理员",
            "updateBy": null,
            "createTime": "2021-11-18 15:22:31",
            "updateTime": null
        },
        {
            "id": 22,
            "pid": 11,
            "value": "4",
            "name": "停电并挂地线",
            "description": "停电并挂地线",
            "orders": "4",
            "status": 1,
            "attr1": "",
            "attr2": "",
            "attr3": "",
            "attr4": "",
            "createBy": "海梁科技-管理员",
            "updateBy": null,
            "createTime": "2021-11-18 15:22:47",
            "updateTime": null
        },
        {
            "id": 23,
            "pid": 11,
            "value": "5",
            "name": "无停送电要求",
            "description": "无停送电要求",
            "orders": "5",
            "status": 1,
            "attr1": "",
            "attr2": "",
            "attr3": "",
            "attr4": "",
            "createBy": "海梁科技-管理员",
            "updateBy": null,
            "createTime": "2021-11-18 15:23:22",
            "updateTime": null
        }
    ]
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