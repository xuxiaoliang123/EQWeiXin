/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-27
 * Time: 下午1:42
 * To change this template use File | Settings | File Templates.
 */

Ext.define('ZSMZJ.view.manager.sysFunctionQueryGrid',{
    extend:'Ext.grid.Panel',
    alias:'widget.sysfunctionquerygrid',
    initComponent:function(){
        Ext.apply(this,{
            dockedItems:[{
                xtype:'toolbar',
                items:[
                    {text:'新增',action:'add'},
                    {text:'删除',action:'delete'}
                ]
            }],
            store:'manager.Functions',

                columns: [
                {xtype: 'rownumberer',width:30},
                {text:'功能ID',dataIndex: 'functionid'},
                {text:'连接',dataIndex: 'location'},
                {text:'标题',dataIndex: 'title',
                    editor:{
                        xtype:'textfield',allowBlank:false
                    }
                },
                {text:'菜单的父节点',dataIndex: 'parent'},
                {text:'在同一级菜单中的序号',dataIndex: 'orderno'},
                {text:'结点类型',dataIndex: 'type'},
                {text:'功能的中文描述',dataIndex: 'description'},
                {text:'在action中是否记日志',dataIndex: 'log'},
                {text:'开发人员',dataIndex: 'developer'},
                {text:'是否可用',dataIndex: 'active',
                    editor:{
                        xtype:'combobox',
                        allowBlank:false,
                        displayField: 'name',
                        valueField: 'abbr',
                        store: Ext.create('Ext.data.Store', {
                            fields: ['abbr', 'name'],
                            data : [
                                {"abbr":"0", "name":"不可用"},
                                {"abbr":"1", "name":"可用"}
                            ]
                        })
                    }
                },
                {text:'功能描述',dataIndex: 'functiondesc'},
                {text:'自动审核标志',dataIndex: 'auflag'},
                {text:'公共函数标志',dataIndex: 'publicflag'},
                {text:'日志数据源',dataIndex: 'prsource'},
                {text:'操作日志回退标志',dataIndex: 'rbflag'},
                {text:'自定义模块参数1',dataIndex: 'param1'},
                {text:'自定义模块参数2',dataIndex: 'param2'},
                {text:'创建时间',dataIndex: 'createdate' },
                    {text:'创建者',dataIndex: 'roleid'},
                {
                    xtype:'actioncolumn', //8
                    width:50,
                    items: [{
                        icon: 'img/edit.png',
                        tooltip: 'Edit',
                        handler: function(grid, rowIndex, colIndex) {
                            var rec = grid.getStore().getAt(rowIndex);
                            Ext.MessageBox.alert('Edit',rec.get('book'));
                        }
                    },{
                        icon: 'img/del.gif',
                        tooltip: 'Delete',
                        handler: function(grid, rowIndex, colIndex) {
                            var rec = grid.getStore().getAt(rowIndex);
                            Ext.MessageBox.alert('Delete',rec.get('book'));
                        }
                    }]
                }
            ],
                bbar: Ext.create('Ext.PagingToolbar', {
                    store: 'manager.Functions',
                    displayInfo: true,
                    displayMsg: 'Displaying topics {0} - {1} of {2}',
                    emptyMsg: "No topics to display",
                    items:[
                        '-', {
                            text: 'Show Preview',
                            enableToggle: true,
                            toggleHandler: function(btn, pressed) {

                            }
                        }]
                })
        }

        )

        this.callParent(arguments);
    }


})