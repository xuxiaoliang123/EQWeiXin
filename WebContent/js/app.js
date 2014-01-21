
Ext.Loader.setConfig({
    enabled: true,
    disableCaching: true,
    paths: {
        'Ext.ux':'js/Ext/ux'
    }

});

var menu_propertycheck=[
    {
        layout: 'fit',
        title: '业务菜单',
        xtype:'navigationbasetree'
    }
];

var splashscreen;
var ViewWaitMask;

Ext.onReady(function() {
    splashscreen = new Ext.LoadMask(Ext.getBody().el, {msg:"页面加载中..."});//{useMsg: false}
    splashscreen.show();

});




Ext.application({
    name: 'ZSMZJ',
    appFolder: 'js/app',
    requires: [

    ],
    controllers: [
         'Navigation','Manager','GroupSend','EarthquakeKnowledge'
    ],

    launch: function() {

        splashscreen.hide();
        Ext.getCmp('west-panel').add(eval(menu_propertycheck));
        window.setTimeout(function(){
            Ext.get('logout').on('click',function(){
                Ext.Ajax.request({
                    url: 'login.do?method=logout',
                    success: function(response){
                        var text = response.responseText;
                        window.location.href="login.jsp";
                    }
                });
            })
        },5000);
    },

    autoCreateViewport: true
});

