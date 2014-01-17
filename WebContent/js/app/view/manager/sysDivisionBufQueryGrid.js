/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-27
 * Time: 下午1:42
 * To change this template use File | Settings | File Templates.
 */

Ext.define('ZSMZJ.view.manager.sysDivisionBufQueryGrid',{
    extend:'Ext.grid.Panel',
    alias:'widget.sysdivisionbufquerygrid',
    initComponent:function(){
        var store=Ext.create('Ext.data.Store',{
          pageSize:50,
            buffered:true,
            purgePageCount:0,
            model:'ZSMZJ.model.manager.Division' ,
            proxy:{
                type:'ajax',
                url:'rain.do',
                extraParams:{
                    pageModel:'sysmanager.Division',
                    eventName:'queryDivision'
                },
                reader:{
                    type:'json',
                    root:'results',
                    totalProperty:'totalCount'
                }
            }
        })
        Ext.apply(this,{

            store:store,
            verticalScrollerType: 'paginggridscroller',
            invalidateScrollerOnRefresh: false,
            disableSelection: true,
                columns: [
                    Ext.create('Ext.grid.RowNumberer'),
                    {text:'简介',xtype:'templatecolumn',width:200,tpl:'{zon301}{zon146}'},
                    { text: '编号', dataIndex: 'zon301',summaryType: 'max' } ,
                    { text: '名称', dataIndex: 'zon146' } ,
                    { text: '级别', dataIndex: 'zon147' } ,
                    { text: '上级编号', dataIndex: 'zon148',
                        summaryType: 'count',
                        summaryRenderer: function(value){
                            return Ext.String.format('{0} student{1}', value, value !== 1 ? 's' : '');
                        }
                    } ,
                    { text: '是否有用', dataIndex: 'zon037' }
                ]
        })

        this.callParent(arguments);
    }


})