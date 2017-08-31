# validation-demo
An easy custom constraint validator demo for request param.Use swagger2 to test

1. @Pattern Detail  
    PatternTest中含一个Pattern的测试，测试结果可以看出正则"||"与"|"的区别:"||"匹配空字符串""为true,|匹配空字符串为false.
当只使用@Pattern不使用@NotNull或@NotBlank时,参数传输为null时依旧会通过验证.

2. Swagger Probleam  
    Swagger2中的@ApiImplicitParams同时含@RequestBody与@RequestParam参数时将使Swagger只接收到@RequestBody参数而接收不到@RequestParam的参数，
故当接口参数同时含@RequestBody与@RequestParam参数时建议使用@ApiImplicitParams中注释@RequestParam参数,而@RequestBody前添加@ApiParam注释，
因为只使用@ApiParam注解接口@RequestParam参数将使得实现方法多出重复冗余的注解，而使用@ApiParam注解VO时会读取VO中的@ApiXxx注解再进行显示。
    In fact,u will understand it from demo. 0,0
    
