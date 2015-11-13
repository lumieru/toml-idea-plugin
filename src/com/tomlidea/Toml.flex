package com.tomlidea;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.tomlidea.psi.TomlTypes;
import com.intellij.psi.TokenType;

%%

%class TomlLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

EOL="\r"|"\n"|"\r\n"
LINE_WS=[\ \t\f]
WHITE_SPACE=({LINE_WS}|{EOL})+

COMMENT=#[^\n\r]*
MULTILINE_STRING=(\"\"\"([^\"\\]|\\(.|[\r\n])|[\r\n])*\"\"\")
STRING=(\"([^\"\\\r\n]|\\.)*\")
//MULTILINE_STRING_SQ=('''([\r\n]|.)*(''')?)
STRING_SQ=('[^\'\r\n]*')

NUMBER=[-+]?[0-9](_?[0-9])*(\.[0-9](_?[0-9])*)?([eE][-+]?[0-9](_?[0-9])*)?

DATE=[0-9]{4}-[0-9]{2}-[0-9]{2}([Tt][0-9]{2}:[0-9]{2}:[0-9]{2}(\.[0-9]+)?)?([Zz]|[+-][0-9]{2}:[0-9]{2})?

BOOLEAN=true|false
KEY=[0-9_\-a-zA-Z]+

%state SQMLSTRING

%%

<YYINITIAL> {
  {WHITE_SPACE}         { return com.intellij.psi.TokenType.WHITE_SPACE; }

  {COMMENT}             { return TomlTypes.COMMENT; }

  '''                   { yybegin(SQMLSTRING); return TomlTypes.SQMSTRQUOTER; }
  {MULTILINE_STRING}    { return TomlTypes.DQMSTRING; }
  {STRING}              { return TomlTypes.DQSSTRING; }
 // {MULTILINE_STRING_SQ} { return TomlTypes.SQMSTRING; }
  {STRING_SQ}           { return TomlTypes.SQSSTRING; }

  {NUMBER}              { return TomlTypes.NUMBER; }
  {DATE}                { return TomlTypes.DATE; }

  {BOOLEAN}             { return TomlTypes.BOOLEAN; }
  {KEY}                 { return TomlTypes.BAREKEY; }

  "."                   { return TomlTypes.DOT; }
  ","                   { return TomlTypes.COMMA; }
  "="                   { return TomlTypes.EQ; }
  "["                   { return TomlTypes.LBRACKET; }
  "]"                   { return TomlTypes.RBRACKET; }
  "{"                   { return TomlTypes.LBRACE; }
  "}"                   { return TomlTypes.RBRACE; }

  [^] { return com.intellij.psi.TokenType.BAD_CHARACTER; }
}

<SQMLSTRING> {
  '''                   { yybegin(YYINITIAL); return TomlTypes.SQMSTRQUOTER; }
  ([\r\n]|.)[^']*       { return TomlTypes.SQMCHAR; }
}