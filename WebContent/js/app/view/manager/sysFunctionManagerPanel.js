Ext.define('ZSMZJ.view.manager.sysFunctionManagerPanel',{
	extend:'Ext.panel.Panel',
	alias:'widget.functionmanagerpanel',
	layout:{
		type:'border'
	},

	initComponent:function(){
		console.log('googd');
		Ext.apply(this,{
			items: [{
				region:'west',
				width: 200,
                parentnode:'totalroot',
                itemId:'managersysfunctiontree',
		        xtype: 'managersysfunctiontree'
		    }, {
		    	region:'center',
                itemId:'managersysfunctionform',
		        xtype: 'managersysfunctionform'
		    }]
		})
		
		this.callParent(arguments);
	}
})