
**接口名称：**

-  xxjob 任务触发

**请求URL：**

- /sys/xxljob/run

**请求方式：**
- POST

**参数：**

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|jobId   |是  |int |任务ID   |
|executorHandler   |是  |String |任务标识   |
|executorParams   |否  |String |任务参数   |
|executorBlockStrategy   |否  |String | 任务阻塞策略，可选值参考 com.xxl.job.core.enums.ExecutorBlockStrategyEnum   |
|executorTimeout   |否  |int |任务超时时间，单位秒，大于零时生效   |
|glueType   |是  |String |任务模式，可选值参考 com.xxl.job.core.glue.GlueTypeEnum   |


**请求示例**
```
POST /sys/xxljob/run HTTP/1.1
Host: {{host}}:{{port}}
{
    "jobId":76,
    "executorHandler":"syncPurchaseByUpdateTime",
    "glueType":"BEAN"
}
```

 **返回示例**
```json
{
    "code":200,
    "message":"success",
    "data":{}
}
```
 **返回参数说明**

|参数名|类型|说明|
|:-----  |:-----|----- |



 **返回错误码说明**
 
|错误码     |说明|
|:-----  |:----- |
|500  |程序内部错误 |

