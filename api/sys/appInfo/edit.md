
**接口名称：**

-  app信息修改

**请求URL：**

- /sys/appInfo/edit

**请求方式：**
- POST

**参数：**

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|id   |否  |Integer |id   |
|appType   |否  |short |app类型 1-用户端(Android) 2-用户端(IOS) 3-运营端(Android) 4-PC端(Windows)  |
|versionNumber   |否  |String |版本号 |
|versionName|否  |String |版本名称 |
|forcedUpdatedInstructions   |否  |String |强制更新说明 |
|updatedInstruction   |否  |String |更新说明 |
|minVersionNumber   |否  |Integer |最低版本 |
|uploadUrl   |否  |String |下载地址 |

**请求示例**
```json
    {
        "id": 78,
        "appType":1,
        "versionNumber":1,
        "versionName":"1.0.0",
        "forcedUpdatedInstructions":"强制更新说明",
        "updatedInstructions":"更新说明",
        "minVersionNumber":1,
        "uploadUrl":"http:192.168.226/apk/test.apk"
    }
```

 **返回示例**
```json
 {
     "code":200,
     "message":"success",
     "data":{
 
     }
 }
```
 **返回参数说明**

|参数名|类型|说明|
|:-----  |:-----|----- |


 **返回错误码说明**
 
|错误码     |说明|
|:-----  |:----- |
|500     |程序内部错误    |

