
**接口名称：** 

-  app版本发布

**请求URL：**

- /sys/appInfo/release

**请求方式：**
- POST

**参数：**

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|id   |否  |Integer |id   |
|appType   |否  |short |app类型 1-用户端(Android) 2-用户端(IOS) 3-运营端(Android) 4-PC端(Windows)  |

**请求示例**
```json
    {
        "id": 78,
        "appType":1
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

