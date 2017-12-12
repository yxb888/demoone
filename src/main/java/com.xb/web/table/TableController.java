	package com.xb.web.table;

    import com.xb.domain.Emps;
    import com.xb.domain.OrganizationTree;
    import com.xb.domain.Table;
    import com.xb.domain.TableType;
    import com.xb.service.table.TableService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.ResponseBody;

    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import java.io.IOException;
    import java.io.PrintWriter;
    import java.util.List;
    import java.util.Map;

	@Controller
    @RequestMapping("tables")
    public class TableController {
        @Autowired
        private TableService tableService;


        @RequestMapping("toqueryTable")
        public String toqueryTable(){
            return "zwlTable/queryTable";
        }

        /**
         * <pre>queryPact(表格查询)
         * 创建人：张万利
         * 创建时间：2017年11月23日 上午10:23:26
         * 修改人：张万利
         * 修改时间：2017年11月23日 上午10:23:26
         * 修改备注：
         * @param page
         * @param rows
         * @param model
         * @param pact
         * @return</pre>
         */
        @RequestMapping("queryTables")
        @ResponseBody
        public Object queryTables(int page , int rows,Table tables){
            Map<String, Object> map = tableService.queryTables(page ,rows,tables);
            return map;
        }

        @RequestMapping("deleteTable")
        public void deleteTable(HttpServletResponse response,Integer tableid) throws IOException{
            String flag = tableService.deleteTable(tableid);
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer =response.getWriter();
            writer.write(flag);
            writer.flush();
            writer.close();
        }

        @RequestMapping("queryType")
        @ResponseBody
        public List<TableType> queryType(){
            List<TableType> lists=tableService.queryType();
            return lists;
        }


        @RequestMapping("toqueryTableType")
        public String toqueryTableType(){
            return "zwlTable/queryTableType";
        }

        @RequestMapping("deleteTableAll")
        @ResponseBody
        public void deleteTableAll(HttpServletRequest re,HttpServletResponse rs){
            String tableids = re.getParameter("tableid");
            String[] tableid = tableids.split(",");

            tableService.deleteAll(tableid);
        }

        @RequestMapping("queryTablesType")
        @ResponseBody
        public Object queryTablesType(int page , int rows,TableType tabletype){
            Map<String, Object> map = tableService.queryTablesType(page ,rows,tabletype);
            return map;
        }

        @RequestMapping("toAddTableType")
        public String toAddTableType(){
            return "zwlTable/toAddTableType";
        }

        @RequestMapping("queryBms")
        @ResponseBody
        public Object queryBms(){
            List<OrganizationTree> menus = tableService.queryBms();
            return  menus;
        }
        @RequestMapping("queryEmps")
        @ResponseBody
        public List<Emps> queryEmps(){
            List<Emps> lists=tableService.queryEmps();
            return lists;
        }

        @RequestMapping("deleteTableType")
        public void deleteTableType(HttpServletResponse response,Integer tabletypeid) throws IOException{
            String flag = tableService.deleteTableType(tabletypeid);
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer =response.getWriter();
            writer.write(flag);
            writer.flush();
            writer.close();
        }

        @RequestMapping("deleteTableTypeAll")
        @ResponseBody
        public void deleteTableTypeAll(HttpServletRequest re,HttpServletResponse rs){
            String tableids = re.getParameter("tabletypeid");
            String[] tabletypeid = tableids.split(",");

            tableService.deleteTableTypeAll(tabletypeid);
        }

        @RequestMapping("addTableType")
        public void addTableType(HttpServletResponse response,TableType tableType){
            String flags= tableService.addTableType(tableType);
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer=null;
            try {
                writer = response.getWriter();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            writer.write(flags);
            writer.flush();
            writer.close();
        }
        @RequestMapping("toaddtables")
        public String toaddtables(){
            return "zwlTable/toaddTable";
        }
    }
