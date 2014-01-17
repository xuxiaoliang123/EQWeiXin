/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-27
 * Time: 下午1:42
 * To change this template use File | Settings | File Templates.
 */

Ext.define('ZSMZJ.view.manager.sysDivisionQueryGrid',{
    extend:'Ext.grid.Panel',
    alias:'widget.sysdivisionquerygrid',
    initComponent:function(){
        Ext.apply(this,{
            store:'manager.Divisions',
            selModel:Ext.create('Ext.selection.CheckboxModel'),
            features:[
                //Ext.create('Ext.grid.feature.Grouping',{ groupHeaderTpl: '统筹区:{aaa148}({rows.length}division{[values.rows.length>1?"s":""]})' })
                //{ groupHeaderTpl: 'Subject: {aaa148}', ftype: 'groupingsummary' },
                {ftype: 'summary'},
                {
                    ftype: 'rowbody',
                    getAdditionalData: function(data, idx, record, orig) {
                        return {
                            rowBody: Ext.String.format(
                                '<div>->topic:<span> {0}</span></div>',
                                data.aaa146)
                        };
                    }
                }  ,{
                    ftype:'rowwrap'
                }
            ],
            columns: [


                Ext.create('Ext.grid.RowNumberer'),
                {text:'简介',xtype:'templatecolumn',width:200,tpl:'{aab301}{aaa146}'},
                { text: '编号', dataIndex: 'aab301',summaryType: 'max' } ,
                { text: '名称', dataIndex: 'aaa146' } ,
                { text: '级别', dataIndex: 'aaa147' } ,
                { text: '上级编号', dataIndex: 'aaa148',
                    summaryType: 'count',
                    summaryRenderer: function(value){
                        return Ext.String.format('{0} student{1}', value, value !== 1 ? 's' : '');
                    }
                } ,
                { text: '是否有用', dataIndex: 'eae037' }
            ],
                bbar: Ext.create('Ext.PagingToolbar', {
                    store: 'manager.Divisions',
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