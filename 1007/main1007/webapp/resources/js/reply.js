const getReplyList=async (mid)=>{
    const response=await axios.get(`/replies/list/${mid}`)
    return response.data
}

async function addReply(obj){
    const response=await axios.post("/replies", obj)
    console.log(response, response.data)
    return response.data
}

const removeReply=async (rno)=>{
    const response=await axios.delete(`/replies/${rno}`)
    return response.data
}

const modifyReply=async (reply)=>{
    const response=await axios.put(`/replies/${reply.rno}`,reply)
    return response.data
}