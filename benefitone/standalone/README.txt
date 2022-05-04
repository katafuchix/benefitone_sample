実行には、以下のjarをクラスパスに設定するだけ：

- appserv-rt.jar (${AppServer}/lib)
- j2ee.jar
- benefitone-demo-ejb.jar
- benefitone-common.jar (*1)

*1) 入出力にBusinessSessionを使っているため。普通はいらないと思う

AppServerと同一ホストからアクセスする場合、InitialContextには何の設定
もいりません。リモートからアクセスする場合、ProviderUrlだけは設定して
下さい。

benefitone-demo-ejb.jarは、antで単にjar化したものです(RMICしたstubは不
要である点に注意)。


実行すると以下のようにfindCustomer()の結果リストが表示されます。

2005/07/27 21:24:59 com.sun.corba.ee.spi.logging.LogWrapperBase doLog
情報: "IOP00710299: (INTERNAL) Successfully created IIOP listener on the specified host/port: all interfaces/3543"
jp.co.benefitone.common.sample.model.CustomerVO:[id=3001,
firstName=FIRST1,
lastName=LAST1,
email=first1@sun.com,
phone=03-5999-2121,
fax=03-5999-2123
department=jp.co.benefitone.common.sample.model.DepartmentVO:[id=2001,
address=YOUGA,
name=JAVA]
company=jp.co.benefitone.common.sample.model.CompanyVO:[id=1001,
name=SUN]]
       :
jp.co.benefitone.common.sample.model.CustomerVO:[id=3015,
firstName=Takeshi,
lastName=Kitano,
email=tk9999@sun.com,
phone=03-5999-2121,
fax=03-5999-2123
department=jp.co.benefitone.common.sample.model.DepartmentVO:[id=2006,
address=SHINJUKU,
name=DOTNET]
company=jp.co.benefitone.common.sample.model.CompanyVO:[id=1003,
name=MS]]
