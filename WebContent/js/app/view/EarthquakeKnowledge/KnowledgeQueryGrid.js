/**
 * User: weipan
 * Date: 14-1-21
 * Time: 下午3:05
 * To change this template use File | Settings | File Templates.
 */

Ext.define('ZSMZJ.view.earthquakeknowledge.KnowledgeQueryGrid',{
    extend:'Ext.grid.Panel',
    alias:'widget.earthquakeknowledgequerygrid',
    initComponent:function(){

        Ext.apply(this,{


            store:'earthquakeknowledge.Knowledges',
            columns: [
                {xtype: 'rownumberer',width:30},
                {text:'知识编号',dataIndex: 'eqk001',flex:1},
                {text:'种类',dataIndex: 'eqk002',flex:1},
                {text:'简要',dataIndex: 'eqk003',flex:1},
                {text:'创建时间',dataIndex: 'eqk004' ,flex:1},
                {text:'创建者',dataIndex: 'eqk005',flex:1},
                {
                    xtype:'actioncolumn', //8
                    width:50,
                    items: [{
                        icon: 'img/edit.png',
                        tooltip: '修改',
                        handler: function(grid, rowIndex, colIndex) {
                            this.up('grid').up('panel').fireEvent('toeditknowledge');
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
            ]
        })


        this.callParent(arguments);
    }
})