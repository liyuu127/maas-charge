
**接口名称：**

-  app信息列表获取

**请求URL：**

- /sys/appInfo/latest

**请求方式：**
- GET

**参数：**

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |

|appType   |否  |Byte |app类型 1-用户端(Android) 2-用户端(IOS) 3-运营端(Android) 4-PC端(Windows)  |

**请求示例**
```json
{
  "appType": 1
}
```

 **返回示例**
```json
{
    "code": 200,
    "msg": "success",
    "data": {
        "id": 101,
        "appFlag": 1,
        "appType": 2,
        "versionNumber": 11,
        "versionName": "1.0.2",
        "forcedUpdatedInstructions": "IOS强制更新",
        "updatedInstructions": "IOS更新说明",
        "minVersionNumber": 1,
        "uploadUrl": "http:192.168.100.46/apks/demo",
        "createdAt": "2021-02-20 15:51:02",
        "updatedAt": "2021-02-20 15:52:04",
        "deleted": 0,
        "valid": 0
    }
}
```
 **返回参数说明**

|参数名|类型|说明|
|:-----  |:-----|----- |
|id  |Integer|id |
|appType  |Byte|app类型 1-移动端(Android) 2-移动端(IOS) 3-车载端(Android) 4-PC端(Windows)  |
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

