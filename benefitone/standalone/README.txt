���s�ɂ́A�ȉ���jar���N���X�p�X�ɐݒ肷�邾���F

- appserv-rt.jar (${AppServer}/lib)
- j2ee.jar
- benefitone-demo-ejb.jar
- benefitone-common.jar (*1)

*1) ���o�͂�BusinessSession���g���Ă��邽�߁B���ʂ͂���Ȃ��Ǝv��

AppServer�Ɠ���z�X�g����A�N�Z�X����ꍇ�AInitialContext�ɂ͉��̐ݒ�
������܂���B�����[�g����A�N�Z�X����ꍇ�AProviderUrl�����͐ݒ肵��
�������B

benefitone-demo-ejb.jar�́Aant�ŒP��jar���������̂ł�(RMIC����stub�͕s
�v�ł���_�ɒ���)�B


���s����ƈȉ��̂悤��findCustomer()�̌��ʃ��X�g���\������܂��B

2005/07/27 21:24:59 com.sun.corba.ee.spi.logging.LogWrapperBase doLog
���: "IOP00710299: (INTERNAL) Successfully created IIOP listener on the specified host/port: all interfaces/3543"
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
