
axios.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
axios.interceptors.response.use(
  function (response) {
	if (response.data && !response.data.success && response.data.code == '4004') {
		console.log("没有登录呢");
		window.location.href = base + "/login.jsp";
	} else {
		return response;
	}
    
  }, 
  function (error) {
    return Promise.reject(error);
  }
);

// 备份原Vue实例
var OriVue = Vue;

// 重定义Vue示例，嵌入页面结构和一些初始化的控制，这里类似一个动态代理模式
Vue = function(options) {
	if (!options.data) {
		options.data = {};
	}
	var data = options.data;
	
	// 页面布局数据
	data.wheight = window.screen.availHeight,
	data.swidth = 200,
	data.activeIndex = '1',
	data.isCollapse = false,
	data.appdisplay = 'none',
	// 菜单跳转后展开选中
	data.initPaht = (function() {
  		var href = window.location.href;
      	var port = window.location.port;
      	var portIndex = href.indexOf(port);
      	console.log(portIndex);
      	console.log(portIndex ? portIndex : href.indexOf(href.host));
      	var searchIndex = href.indexOf("?" + href.search);
      	console.log(searchIndex);
      	var path = href.substring(portIndex > -1 ? portIndex + port.length : href.indexOf(href.host), searchIndex > -1 ? searchIndex : href.length);
      	console.log(path);
      	path = path.replace(window.location.protocol + "//" + window.location.host, "");
      	console.log(path);
      	return path;
  	})();
	
	/*data.sys_user_headimg = sys_user_headimg;*/
	
	
	if (!options.methods) {
		options.methods = {};
	}
	var methods = options.methods;
	
	methods.showOrColl = function() {
      	this.isCollapse = !this.isCollapse;
    };
    
    methods.menuItemClick = function(index) {
      	console.log(index);
      	window.location.href = index;
    };
    methods.toIndex = function() {
    	  window.location.href = base + "/a/home.jsp";
    };
    
    methods.accountset = function() {
		window.location.href = base + "/a/sysuser/accountset.jsp";
	};
	
	methods.logout = function() {
		this.$confirm('您确定要退出系统吗？', '系统提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
        })
        .then(function() {
        	window.location.href = base + "/a/accountSet/logout";
        });
		
	}
	
    // 解决渲染前的丑陋一刻
	var cf = options.created;
	if (cf) {
		options.created = function () {
			this.appdisplay = "block";
	    	console.log(this.initPaht);
	    	cf.call(this);
		}
	} else {
		options.created = function () {
			this.appdisplay = "block";
	    	console.log(this.initPaht);
		}
	}
	
	// 创建原始的Vue实例
	return new OriVue(options);
}