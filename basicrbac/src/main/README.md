https://blog.csdn.net/hlz5857475/article/details/81333192
当两种标签都没有的时候，框架默认注册的有AnnotationMethodHandlerAdapter这个bean，所以能够处理@RequestMapping这个注解，
但是只配置了<mvc:default-servlet-handler/>时所注册的三个bean都不能处理@RequestMapping注解，
因此无法找到相应的Controller，进而无法进行访问路径的映射，当两种标签都有的时候，
<mvc:annotation-driven/>会注册一个RequestMappingHandlerAdapter的bean，这个bean能够处理@RequestMapping这个注解。


servlet 和 servlet-jstl(支持el表达式)版本依赖关系
https://www.cnblogs.com/autumnlj/articles/14225058.html