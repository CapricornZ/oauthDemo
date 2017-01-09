Spring Boot OAuth2 演示（只演示了client_credentials）

1. AuthServer:运行在8080
  1.1 执行如下，获取AccessToken
    curl http://localhost:8080/oauth/token?grant_type=client_credentials -u clientIdPassword:secret -X POST -v
    
  1.2 执行如下，根据AccessToken获取用户信息
    curl http://localhost:8080/oauth/check_token -d token=e3da689e-e828-47f8-913a-38b86544f9bf -u clientIdPassword:secret
    参数token就是1.1步中获取的内容
    
2. ResourceServer(client)：运行在8090
  根据1.1获取的AccessToken，访问restful 接口
  curl http://localhost:8090/foos/1 -H "Authorization: Bearer e3da689e-e828-47f8-913a-38b86544f9bf"
