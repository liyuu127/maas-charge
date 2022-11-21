
**接口名称：**

-  app信息列表获取

**请求URL：**

- /sys/appInfo/list

**请求方式：**
- GET

**参数：**

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|page   |否  |Integer |分页页码   |
|pageSize   |否  |Integer |分页大小   |
|type   |否  |Byte |app类型 1-用户端(Android) 2-用户端(IOS) 3-运营端(Android) 4-PC端(Windows)  |
|versionNumber   |否  |Integer |app版本号   |
|versionName   |否  |String |app版本名称   |

**请求示例**
```json
    {
      "page": 1,
      "pageSize": 20,
      "type": 1,
      "versionNumber": 1,
      "versionName": "1.0.0"
}
```

 **返回示例**
```json
{
    "code":200,
    "message":"success",
    "data":{
        "total":1,
        "current":1,
        "pageCount":1,
        "list":[
            {
                "id":1,
                "appType":1,
                "versionNumber":6,
                "versionName":"1.0.3",
                "forcedUpdatedInstructions":"强制更新",
                "updatedInstructions":"1. 测试更新功能;2. 测试更新功能;3. 测试更新功能。",
                "minVersionNumber":1,
                "uploadUrl":"https://fanyiapp.cdn.bcebos.com/app/v8.5.1/app-webbutton-release.apk",
                "uploadAt":"2020-12-01 12:30:59",
                "valid": 0
            }
        ]
    }
}
```
 **返回参数说明**

|参数名|类型|说明|
|:-----  |:-----|----- |
|id  |Integer|id |
|appType  |Byte|app类型 1安卓 2-IOS  |
|versionNumber  |Integer|版本号 |
|versionName  |String|版本名称 |
|forcedUpdatedInstructions  |String|强制更新说明 |
|updatedInstructions  |String|更新说明 |
|minVersionNumber  |Integer |最低版本 |
|uploadUrl  |String |下载地址 |
|updatedAt  |LocalDateTime |上次更新时间 |
|valid  |Byte |是否是当前生效版本 0-否 1-是 |


 **返回错误码说明**
 
|错误码     |说明|
|:-----  |:----- |
|500  |程序内部错误 |

