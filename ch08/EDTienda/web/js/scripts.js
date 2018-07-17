/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (){
  'use strict';

  var menu = $('menu'),
      openMenu = $('open-menu'),
      closeMenu = $('close-menu');

  openMenu.addEventListener('click', function () {
    menu.classList.add('mostrar');
  });

  closeMenu.addEventListener('click', function () {
    menu.classList.remove('mostrar');
  });

  function $(id) {
    return document.getElementById(id);
  }
})(document);

