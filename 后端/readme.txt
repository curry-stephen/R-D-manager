R&D_Managmet源码简述

按以下步骤进入后端项目目录：
DrugMapper->src->main->java->com->example

controller目录：
		BillController：账单信息接口
		DruginfoController：药品信息接口
		FileController：文件上传与下载接口
		LogController：用户登录接口
		MatterController：问题药品接口
		OwinfoController：药品出入库接口
		ReturngoodsController：退货接口
		ReturnsupplierController：退货给供应商接口
		SaleinfoController：销售记录接口
		SupplierController：供应商信息接口
		UserController：用户管理接口
		
		menhu目录：
			DongtaiAboutController：动态分享页面数据接口
			DrugAndFuController：医院党建页面数据接口
			
			add目录：
				AddInfo：门户网站数据添加接口

utils目录：
	CorsConfig：前后端跨域配置
	DateUtil：日期处理工具
	LogUtis：日志处理工具
	MPconfig：MyBatisPlus分页配置
	Result：后端返回结果封装工具
	ResultLog：后端日志返回结果封装工具

entity目录用于项目中的载体对象
server目录为业务层 
mapper目录、log目录为数据访问映射层


按以下步骤进入目录：
DrugMapper->src->main->resources

files目录为前端上传文件保存目录
application：后端服务器配置文件

