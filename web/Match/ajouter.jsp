<%! 
    String type[]={"Championat","Coupe du Monde","Eliminatoire","Amical"}; 
%>

<div class="container">
    <form method="post" action="${pageContext.request.contextPath}/Matches">
        <div >
            <label for="type" >Type Match</label>
            <div class="col-sm-10">
                <select name="type" class="form-control">
                    <%for (String s:type){%>
                    <option value="<%=s%>"><%=s%></option>
                    <%}%>
                </select>
            </div>
        </div>
        <div >
            <label for="pays" class="col">Pays</label>
            <div class="col-sm-10">
                <input type="text" id="pays" name="pays">
            </div>
        </div>
        <div>
            <label for="dateMatch" >Date Mach</label>
            <div class="col-sm-10">
                <input type="date" id="dateMatch" name="dateMatch">
            </div>
        </div>
        <div>
            <label for="heureMatch" >Heure Mach</label>
            <div class="col-sm-10">
                <input type="time" id="heureMatch" name="heureMatch">
            </div>
        </div>
        <div>
            <label for="equipeR">Equipe Receveuse</label>
            <div>
                <input type="text" id="equipeR" name="equipeR">
            </div>
        </div>
        <div>
            <label for="equipeV">Equipe Visiteuse</label>
            <div>
                <input type="text" id="equipeV" name="equipeV">
            </div>
        </div>
        <div>
            <label for="cote">Cote</label>
            <div>
                <input type="number" id="cote" name="cote">
            </div>
        </div>
        <div>
            <label for="score">Score Final</label>
            <div>
                <input type="text" disabled  id="score" name="score">
            </div>
        </div>
        <input type="submit"   value="enregistrer">
    </form>
</div>


