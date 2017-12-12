//--------------------------------------------------------------------------
// File:        top.js
// Description: top menu javascript
// Rev:         0.9
// Created:     Mar 21, 2011
// Author:      北京汇金宝科技有限公司 (FangChen)
//
// Copyright Wistron Information Technology & Services Corp.
//
//--------------------------------------------------------------------------

//-- function
function getElement(parentDocument, id) {
    return parentDocument.getElementById(id);
}

// show Main Frame and Tree Frame
function showMainFrame(aLink, isShowTree, hrefLink, treeID){
//    var treeFObj = parent.document.getElementById("treeF");
//    var showFObj = parent.document.getElementById("showF");
//    if( isShowTree == true ){
//        showFObj.cols = "20%,*";
//
//        var jumpURL = "Tree.html";
//        if( treeID != undefined && treeID.length > 0 ){
//            jumpURL = jumpURL + "?treeFile="+treeID;
//        }
//        treeFObj.noResize = false;
//        treeFObj.src = jumpURL;
//    } else {
//        showFObj.cols = "0,*";
//        treeFObj.noResize = true;
//        treeFObj.src = "";
//    }
//    aLink.href = hrefLink;
//    aLink.target = "mainF";
}

// show Main Frame and Tree Frame
function showMainFrameCheckboxTree(aLink, isShowTree, hrefLink, treeID){
    var treeFObj = parent.document.getElementById("treeF");
    var showFObj = parent.document.getElementById("showF");
    if( isShowTree == true ){
        showFObj.cols = "20%,*";
        var jumpURL = "TreeCheckBox.html";
        if( treeID != undefined && treeID.length > 0 ){
            jumpURL = jumpURL + "?treeFile="+treeID;
        }
        treeFObj.noResize = false;
        treeFObj.src = jumpURL;
    } else {
        showFObj.cols = "0,*";
        treeFObj.noResize = true;
        treeFObj.src = "";
    }
    aLink.href = hrefLink;
    aLink.target = "mainF";
}

function deploy (id,imgId){
var fId = document.getElementById(id);
    if(fId.style.display == 'none'){
        fId.style.display = '';
        document.images[imgId].src = ctx +"/images/close.gif";
    }else{
        fId.style.display = 'none';
        document.images[imgId].src = ctx +"/images/open.gif";
    }
}

function deployListAndFun(id,imgId,btnFunId){
var fId = document.getElementById(id);
var btnIdObj = document.getElementById(btnFunId);
    if(fId.style.display == 'none'){
        fId.style.display = '';
        btnIdObj.style.display = '';
        document.images[imgId].src = ctx +"/images/close.gif";
    }else{
        fId.style.display = 'none';
        btnIdObj.style.display = 'none';
        document.images[imgId].src = ctx +"/images/open.gif";
    }
}

//---------------------------------------------------------------------menu----------------------------------//

if (!document.getElementById) {
    document.getElementById = function() {
        return null;
    }
}

function initMenu() {
//    var uls = document.getElementById("menu");
//    var items = (uls.getElementsByTagName("A"));
//    jQuery(".menuList a").each(function()
//        {
//	    	this.onclick = function() {
//	            setCookie("menuSelected", this.id);
//	        };
//        });
    activateMenu();

}

function activateMenu() {
    var activeMenu;
    var found = 0;
    var current = document.location.toString();
    current = current.substring(0, current.lastIndexOf('/'));
    jQuery(".menuList a").each(function()
        {
    		var url = this.href;
    		if (url &&  url != ""){
    	        url = url.substring(0, url.lastIndexOf('/'));
    	        if (current.indexOf(url) != -1) {
	        		this.className += "menuSel";
    	            return;
    	        }
    		}
        });
//    for (var i = 0; i < items.length; i++) {
//        var url = items[i].getAttribute("href");
//        if (url &&  url != ""){
//
//        var current = document.location.toString();
//        current = current.substring(0, current.lastIndexOf('/'));
//        url = url.substring(0, url.lastIndexOf('/'));
//        /*if (current.indexOf(url) != -1) {
//            found++;
//        } */
//
//        if (current.indexOf(url) != -1) {
//
//            if (items[i].parentNode.parentNode.className == "submenu") {
//                items[i].className = "active";
//                items[i].parentNode.parentNode.parentNode.className = "active";
//            } else {
//                items[i].parentNode.className += "active";
//
//            }
//            return;
//        }
//            }
//    }

    // more than one found, use cookies
    /* if (found > 1) {
       var menuSelected = getCookie("menuSelected");
       if (items[menuSelected].parentNode.className == "submenu") {
           items[menuSelected].firstChild.className="selected";
           items[menuSelected].parentNode.parentNode.className="selected";
       } else {
           items[menuSelected].className+="selected";
       }
   } else {
       // only one found, match on URL
       for (var i=0; i < items.length; i++) {
           var url = items[i].firstChild.getAttribute("href");
           var current = document.location.toString();
           if (current.indexOf(url) != -1) {
               if (items[i].parentNode.className == "submenu") {
                   items[i].firstChild.className="selected";
                   items[i].parentNode.parentNode.className="selected";
               } else {
                   items[i].className+="selected";
               }
           }
       }
   } */
}


// =========================================================================
//                          Cookie functions
// =========================================================================
/* This function is used to set cookies */
function setCookie(name, value, expires, path, domain, secure) {
    document.cookie = name + "=" + escape(value) +
                      ((expires) ? "; expires=" + expires.toGMTString() : "") +
                      ((path) ? "; path=" + path : "") +
                      ((domain) ? "; domain=" + domain : "") + ((secure) ? "; secure" : "");
}

/* This function is used to get cookies */
function getCookie(name) {
    var prefix = name + "="
    var start = document.cookie.indexOf(prefix)

    if (start == -1) {
        return null;
    }

    var end = document.cookie.indexOf(";", start + prefix.length)
    if (end == -1) {
        end = document.cookie.length;
    }

    var value = document.cookie.substring(start + prefix.length, end)
    return unescape(value);
}

/* This function is used to delete cookies */
function deleteCookie(name, path, domain) {
    if (getCookie(name)) {
        document.cookie = name + "=" +
                          ((path) ? "; path=" + path : "") +
                          ((domain) ? "; domain=" + domain : "") +
                          "; expires=Thu, 01-Jan-70 00:00:01 GMT";
    }
}