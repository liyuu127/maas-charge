**接口名称：**

- ```
  获取国际化所有配置数据
  ```

**请求URL：**

{{host}}:{{port}}/sys/internationalization/findAll

**请求方式：**

- GET

**参数：**

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|        |      |      |      |

**请求示例**

```
--request GET 'http://localhost:8089/sys/internationalization/findAll'
--header 'Content-Type: application/json'

```

 **返回示例**
```json
{
    "code": 200,
    "message": "操作成功",
    "time": "2022-03-17 01:21:06",
    "data": [
        {
            "id": 2,
            "code": "DFS.Formula.RawMaterialMismatching",
            "value": "当前扫描原料不在该产品生产BOM清单中,请仔细核对!",
            "status": 1,
            "createTime": "2022-03-16T21:41:41",
            "updateTime": null
        },
        {
            "id": 3,
            "code": "DFS.Formula.RawMaterialOverweight",
            "value": "该原料已超出预期数量，请仔细核对！",
            "status": 1,
            "createTime": "2022-03-16T21:41:41",
            "updateTime": null
        }
    ]
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