// Title: Tigra Tree
// Description: See the demo at url
// URL: http://www.softcomplex.com/products/tigra_menu_tree/
// Version: 1.1
// Date: 11-12-2002 (mm-dd-yyyy)
// Contact: feedback@softcomplex.com (specify product title in the subject)
// Notes: This script is free. Visit official site for further details.


var second_tree_tpl = {
    'target'  : 'content',	// name of the frame links will be opened in
                            // other possible values are: _blank, _parent, _search, _self and _top

    'icon_e'  : ctx+'/icons/empty.gif', // empty image
    'icon_l'  : ctx+'/icons/line.gif',  // vertical line

    'icon_48' : ctx+'/icons/base.gif',   // root icon normal
    'icon_52' : ctx+'/icons/base.gif',   // root icon selected
    'icon_56' : ctx+'/icons/base.gif',   // root icon opened
    'icon_60' : ctx+'/icons/base.gif',   // root icon selected

    'icon_16' : ctx+'/icons/folder.gif', // node icon normal
    'icon_20' : ctx+'/icons/folderopen.gif', // node icon selected
    'icon_24' : ctx+'/icons/folder.gif', // node icon opened
    'icon_28' : ctx+'/icons/folderopen.gif', // node icon selected opened

    'icon_0'  : ctx+'/icons/page.gif', // leaf icon normal
    'icon_4'  : ctx+'/icons/page.gif', // leaf icon selected
    'icon_8'  : ctx+'/icons/page.gif', // leaf icon opened
    'icon_12' : ctx+'/icons/page.gif', // leaf icon selected

    'icon_2'  : ctx+'/icons/joinbottom.gif', // junction for leaf
    'icon_3'  : ctx+'/icons/join.gif',       // junction for last leaf
    'icon_18' : ctx+'/icons/plusbottom.gif', // junction for closed node
    'icon_19' : ctx+'/icons/plus.gif',       // junctioin for last closed node
    'icon_26' : ctx+'/icons/minusbottom.gif',// junction for opened node
    'icon_27' : ctx+'/icons/minus.gif'       // junctioin for last opended node
};


function second_tree (a_items, a_template) {
//function tree (a_items, a_template) {

    this.a_tpl      = a_template;
    this.a_config   = a_items;
    this.o_root     = this;
    this.a_index    = [];
    this.o_selected = null;
    this.n_depth    = -1;
    var o_icone = new Image(),
        o_iconl = new Image();
    o_icone.src = a_template['icon_e'];
    o_iconl.src = a_template['icon_l'];
    a_template['im_e'] = o_icone;
    a_template['im_l'] = o_iconl;
    
    for (var i = 0; i < 64; i++){
        if (a_template['icon_' + i]) {
            var o_icon = new Image();
            a_template['im_' + i] = o_icon;
            o_icon.src = a_template['icon_' + i];
        }
	}
	
    this.toggle = function (n_id) {	var o_item = this.a_index[n_id]; o_item.open(o_item.b_opened); };
//	this.select = function (n_id) { return this.a_index[n_id].select(); };
//	this.mout   = function (n_id) { this.a_index[n_id].upstatus(true) };
//	this.mover  = function (n_id) { this.a_index[n_id].upstatus() };
    this.a_children = [];
    for (var i = 0; i < a_items.length; i++){
        new second_tree_item(this, i);
	}
	
    this.n_id = second_trees.length;
    second_trees[this.n_id] = this;
    document.write('<table cellpadding="0" cellspacing="0" border="0"><tr><td width="15"></td><td class="text1">');
    for (var i = 0; i < this.a_children.length; i++) {
        document.write(this.a_children[i].init());
    }
    document.write('</td></tr></table><br>');
    second_initSelectedStr='';
}

function second_tree_item (o_parent, n_order) {

    this.n_depth  = o_parent.n_depth + 1;
    this.a_config = o_parent.a_config[n_order + (this.n_depth ? 3 : 0)];
    if (!this.a_config) return;

    this.o_root    = o_parent.o_root;
    this.o_parent  = o_parent;
    this.n_order   = n_order;
    this.b_opened  = !this.n_depth;

    this.n_id = this.o_root.a_index.length;
    this.o_root.a_index[this.n_id] = this;
    this.e_id = '';
    this.get_eid = second_item_getElementId;
    o_parent.a_children[n_order] = this;

    this.a_children = [];
    for (var i = 0; i < this.a_config.length - 3; i++)
        new second_tree_item(this, i);

    this.get_icon = second_item_get_icon;
    this.open     = second_item_open;
    this.select   = second_item_select;
    this.selected = false;
    this.init     = second_item_init;
    this.upstatus = second_item_upstatus;
    this.is_last  = function () { return this.n_order == this.o_parent.a_children.length - 1 };
}

function second_item_open (b_close) {
    var o_idiv = second_get_element('second_i_div' + this.o_root.n_id + '_' + this.n_id);
    if (!o_idiv) return;

    if (!o_idiv.innerHTML) {
        var a_children = [];
        for (var i = 0; i < this.a_children.length; i++)
            a_children[i]= this.a_children[i].init();
        o_idiv.innerHTML = a_children.join('');
    }
    //initItemInnerHtml(this);
    o_idiv.style.display = (b_close ? 'none' : 'block');

    this.b_opened = !b_close;
    var o_jicon = document.images['j_img' + this.o_root.n_id + '_' + this.n_id],
        o_iicon = document.images['i_img' + this.o_root.n_id + '_' + this.n_id];
    if (o_jicon) o_jicon.src = this.get_icon(true);
    if (o_iicon) o_iicon.src = this.get_icon();

}

function second_item_select (bSelected) {
// for test
	alert("选中的节点是：" + this.a_config[0] );
    second_setAllParentSelected(this, bSelected);
    second_setAllChildrenSelected(this, bSelected);
    second_setItemSelected(this, bSelected);
}

function second_item_upstatus (b_clear) {
    window.setTimeout('window.status="' + (b_clear ? '' : this.a_config[0] + (this.a_config[1] ? ' ('+ this.a_config[1] + ')' : '')) + '"', 10);
}

function second_item_getElementId()
{
    if (this.e_id =='')
    {
        this.e_id = 'e' + this.o_root.n_id + '_' + this.n_id + '_' + this.a_config[0];
    }

    return this.e_id;
}

function second_item_init () {
    var a_offset = [],
        o_current_item = this.o_parent;
    for (var i = this.n_depth; i > 1; i--) {
        a_offset[i] = '<img src="' + this.o_root.a_tpl[o_current_item.is_last() ? 'icon_e' : 'icon_l'] + '" border="0" align="absbottom">';
        o_current_item = o_current_item.o_parent;
    }
    var childString = '';
    if (this.a_children.length)
    {
        for (var i=0; i<this.a_children.length; i++)
        {
            childString = childString + this.a_children[i].init();
        }
    }
    var display = this.b_opened ? 'block' : 'none';
    var ischecked = '';
    if (second_bInitSelected &&
        second_initSelectedStr.indexOf(';' + this.a_config[0] + ';') >= 0)
    {
        ischecked = ' checked';
    }
    var sDisabled ='';
    if (second_bDisabled)
    {
        sDisabled = ' disabled="true" ';
    }
    var result = '<table cellpadding="0" cellspacing="0" border="0"><tr><td class="text1" nowrap>'
                 + (this.n_depth ? a_offset.join('')
                                   + (this.a_children.length ? '<a href="javascript: second_trees[' + this.o_root.n_id + '].toggle(' + this.n_id + ')"><img src="' + this.get_icon(true) + '" border="0" align="absbottom" name="j_img' + this.o_root.n_id + '_' + this.n_id + '"></a>'
                                                                : '<img src="' + this.get_icon(true) + '" border="0" align="absbottom">')
                                  : '')
        + '<input type="checkbox" class="In1" id="' + this.get_eid() + '" value="' + this.get_eid() + '"' + ischecked + sDisabled + ' onclick="second_item_checked(\''+ this.n_id +'\',\'' + this.o_root.n_id + '\')">' + this.a_config[1] + '</td></tr></table>'
        + (this.a_children.length ? '<div id="second_i_div' + this.o_root.n_id + '_' + this.n_id + '" style="display:' + display + '">' + childString + '</div>'
                                     : '');
    return result;
}

function second_item_get_icon (b_junction) {
    return this.o_root.a_tpl['icon_' + ((this.n_depth ? 0 : 32) + (this.a_children.length ? 16 : 0) + (this.a_children.length && this.b_opened ? 8 : 0) + (!b_junction && this.o_root.o_selected == this ? 4 : 0) + (b_junction ? 2 : 0) + (b_junction && this.is_last() ? 1 : 0))];
}

//选中结点事件
function second_item_checked(itemIndex, treeIndex)
{
    var item = second_trees[treeIndex].a_index[itemIndex];
    var bSelected = second_getItemSelected(item);
    item.select(bSelected);
}

//查看某个结点是否被选中
function second_getItemSelected(item)
{
    var e_item = second_getElementByItem(item);
    var bSelected = false;
    if (e_item != '')
    {
        bSelected = e_item.checked;
    }
    item.selected = bSelected;
    return bSelected;
}

//设置某个结点选中状态
function second_setItemSelected(item, bSelected)
{
// for test
	alert( "选中的节点是：" + item.a_config[0] );
    var e_item = second_getElementByItem(item);
    if (e_item != '')
    {
        second_setElementSelected(e_item,item, bSelected);
    }
}

//设置脚本对象的选中状态
function second_setElementSelected(elementItem, item, bSelected)
{
// for test
	alert("选中的节点是：" + item.a_config[0] );

    if (bfirst)
    {
        second_initSelected();
        bfirst = false;
    }

    elementItem.checked = bSelected;
    item.selected = bSelected;
    var itemid = item.a_config[0];
    if (bSelected)
    {
        second_addToSelected(itemid);
    }
    else
    {
        second_removeFromSelected(itemid);
    }
}

//设置所有的父结点的状态
function second_setAllParentSelected(item, bSelected)
{
    var o_parent = item.o_parent;
    if (o_parent != second_trees[item.o_root.n_id])
    {
        var e_parent = second_getElementByItem(o_parent);
        if (bSelected) //如果被选中
        {
            if (!e_parent.checked)
            {
                second_setElementSelected(e_parent, o_parent, true);
                second_setAllParentSelected(o_parent, true);
            }
        }
        else //取消选中
        {
            if (o_parent.a_children+'.' != '.') //存在父结点
            {
                var selectedCount = 0;
                for (var i = 0; i < o_parent.a_children.length; i++)
                {
                    if (second_getItemSelected(o_parent.a_children[i]))
                    {
                        selectedCount++;
                    }
                }
                if (selectedCount == 0)
                {
                    second_setElementSelected(e_parent,o_parent, false);
                    second_setAllParentSelected(o_parent, false);
                }
            }
        }
    }
}

//设置所有的子结点的状态
function second_setAllChildrenSelected(item, bSelected)
{
    if (item.a_children+'.' != '.') //存在子结点
    {
        for (var i = 0; i <item.a_children.length; i++)
        {
            second_setItemSelected(item.a_children[i], bSelected);
            second_setAllChildrenSelected(item.a_children[i], bSelected);
        }
    }
}

//获取结点对应的脚本对象
function second_getElementByItem(item)
{
    var e_item = second_get_element(item.get_eid());
    if(e_item +'.' == 'undefined.')
    {
        return '';
    }
    return e_item;
}

//添加到选中的结点
function second_addToSelected(itemid)
{
	// for test
	alert( "选中的节点是：" + itemid );
    var isExisted = false;
    for (var i =0; i< second_selectedList.length; i++)
    {
        if (second_selectedList[i] == itemid)
        {
            isExisted  = true;
            break;
        }
    }
    if (isExisted)
    {
        return;
    }
    else
    {
        second_selectedList[second_selectedList.length] = itemid;
    }
}

//从选中的结点删除
function second_removeFromSelected(itemid)
{
    var newList = [];
    var index = 0;
    for (var i =0; i< second_selectedList.length; i++)
    {
        if (second_selectedList[i] != itemid)
        {
            newList[index] = second_selectedList[i];
            index = index+1;
        }
    }
    second_selectedList = newList;
}

//检查是否有选中至少一个节点
function second_checkSelectedTreeNode()
{
    if (bfirst)
    {
        second_initSelected();
    }
    if (second_selectedList + '.' == '.')
    {
    	alert('请先选中一个结点!');
        return false;
    }
    else
    {
        return true;
    }
}

//保存选中的节点ID
function second_saveSelectedTreeNode()
{
     if (bfirst)
    {
        second_initSelected();
    }
	var selectStr = '';
	for (var i =0; i< second_selectedList.length; i++)
	{
		if (second_selectedList[i] != '')
		{
			selectStr += second_selectedList[i] + ';';
		}
	}
	if (selectStr!='')
	{
		selectStr = selectStr.substring(0, selectStr.length-1);
	}
	//second_get_element(second_hiddenname).value = selectStr;
	second_get_element(hiddenname).value = selectStr;
}

//初始化选择
function second_initSelected()
{
    //if(second_get_element(second_hiddenname)+'.' != 'undefined.')
    if(second_get_element(hiddenname)+'.' != 'undefined.')
    {
        //second_initSelectedStr = second_get_element(second_hiddenname).value;
        second_initSelectedStr = second_get_element(hiddenname).value;
        second_selectedList = second_initSelectedStr.split(';');
        second_initSelectedStr = '';
    }
    else
    {
        if (second_initSelectedStr == '')
        {
            return;
        }
        second_selectedList = second_initSelectedStr.split(';');
        second_initSelectedStr = ';' + second_initSelectedStr + ';';
        second_bInitSelected = true;
    }
}


var second_trees = [];
second_get_element = document.all ?
    function (s_id) { return document.all[s_id] } :
    function (s_id) { return document.getElementById(s_id) };
var second_bfirst = true;
var second_bInitSelected = false;
var second_selectedList = [];

