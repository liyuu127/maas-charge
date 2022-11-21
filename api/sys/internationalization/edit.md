**接口名称：**

- 国际化编辑

**请求URL：**

{{host}}:{{port}}/sys/internationalization/edit

**请求方式：**
- POST

**参数：**

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|id|是|Integer|国际化配置id|
|code|否|String|国际化配置code|
|value   |否  |String |国际化配置value|
|status   |否  |Integer |国际化配置禁用状态(0-未启用,1-启用)|

**请求示例**
```json
{
  "id": 22,
  "code": "TEST",
  "value": "测试"
}
```

 **返回示例**
```json
{
    "code": 200,
    "message": "操作成功",
    "result": ""
}
```
 **返回参数说明**

|参数名|类型|说明|
|:-----  |:-----|----- |




 **返回错误码说明**

|错误码 |信息|说明|
|:----  |:----   |-----   |
|300_003  |Health.Stagecoach.Business.SysInternationalizationCodeAlreadyExist   |新增国际化配置code已存在   |
