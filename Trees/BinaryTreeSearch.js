// import {NODO} from './NODO';
function NODO(data, left, right){
  this.data = data;
  this.left = left;
  this.right =right;
  this.show = show;
}

function show(){return this.data}


class BTS{
    root = null;
    cantLeaf;

    
    

    preOrder(){
        this.preOrderProcess(this.root)    
    }
    preOrderProcess(node){
                    if(!(node == null)){
                        console.log(node.show())
                        this.preOrderProcess(node.left);
                        this.preOrderProcess(node.right);
                    }
                }

    inOrder(){
        this.inOrderProcess(this.root)    
    }
    inOrderProcess(node){
                    if(!(node == null)){
                    this.inOrderProcess(node.left);
                    console.log(node.show())
                    this.inOrderProcess(node.right);
                    }
                }


    postOrder(){
        this.postOrderProcess(this.root)    
    }                
    postOrderProcess(node){
                    if(!(node == null)){
                    this.postOrderProcess(node.left);
                    this.postOrderProcess(node.right);
                    console.log(node.show())
                    }
                }

    getMin(root){
        if(root)
        {
            let current = root;
            while(!(current.left == null)){
                current = current.left;
            }
            return current;
        }
        return null;
    }
    getMax(root){
        if(root)
        {
            let current = root;
            while(!(current.right == null)){
                current = current.right;
            }
            return current;
        }
        return null;
    }
    insert(data){
      var n = new NODO(data, null, null);
      if(this.root ==null){this.root =n}
      else{
        var current =this.root;
        var parent;
        while(true){
          parent = current;
          if( data < current.data){
             current = current.left
             if(current ==null){
                parent.left=n;
                break;
             }
          }
          else{
            current = current.right;
            if(current == null){
              parent.right = n;
              break;
            }
          }
        }
      }
    }

    find(data){
        let current = this.root;
        while(current != null){

            if(data == current.data)
                return current;
            else{
                if(data < current.data )
                    current = current.left;
                else
                    current = current.right;
            }
        }
        return current;
    }

    remove(data){
        this.removeNode(this.root, data)
    }

    removeNode(node, data){
        console.log(data)
        if(node == null)
          return null;
        if (data == node.data)
        {   
            /*node leaf*/
            if(node.left == null && node.right ==null)
                return null;
            else if (node.left == null){
                return node.right;
            }
            else if (node.right  == null){
                return node.left;
            }
            let tempNode = this.getMin(node.right)
            node.data = tempNode.data;
            node.right=this.removeNode(node.right, tempNode.data)
            return node;
        }
        if(data < node.data){
            node.left = this.removeNode(node.left, data);
            return node;
        }
        else{
            node.right = this.removeNode(node.right, data);
            return node;
        }
    }

}


let tree = new BTS();
tree.insert(23);
tree.insert(45);
tree.insert(16);
tree.insert(37);
tree.insert(3);
tree.insert(99);
tree.insert(22);

tree.inOrder()