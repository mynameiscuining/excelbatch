sample
===
* 注释

	select #use("cols")# from I_USERINFO  where  #use("condition")#

cols
===
	loginAccount,userName,email,phoneNum,address,certType,certificate,createTime,modifyTime,createOperator,modifyOperator,languagePref

updateSample
===
	
	loginAccount=#loginaccount#,userName=#username#,email=#email#,phoneNum=#phonenum#,address=#address#,certType=#certtype#,certificate=#certificate#,createTime=#createtime#,modifyTime=#modifytime#,createOperator=#createoperator#,modifyOperator=#modifyoperator#,languagePref=#languagepref#

condition
===

	1 = 1  
	@if(!isEmpty(loginaccount)){
	 and loginAccount=#loginaccount#
	@}
	@if(!isEmpty(username)){
	 and userName=#username#
	@}
	@if(!isEmpty(email)){
	 and email=#email#
	@}
	@if(!isEmpty(phonenum)){
	 and phoneNum=#phonenum#
	@}
	@if(!isEmpty(address)){
	 and address=#address#
	@}
	@if(!isEmpty(certtype)){
	 and certType=#certtype#
	@}
	@if(!isEmpty(certificate)){
	 and certificate=#certificate#
	@}
	@if(!isEmpty(createtime)){
	 and createTime=#createtime#
	@}
	@if(!isEmpty(modifytime)){
	 and modifyTime=#modifytime#
	@}
	@if(!isEmpty(createoperator)){
	 and createOperator=#createoperator#
	@}
	@if(!isEmpty(modifyoperator)){
	 and modifyOperator=#modifyoperator#
	@}
	@if(!isEmpty(languagepref)){
	 and languagePref=#languagepref#
	@}
	
	